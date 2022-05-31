package taskForSynchronized;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CounterNumberInsideFileNoneAtomic implements Runnable{

    private Accumulator accumulator;
    private FileReader fileReader;

    public CounterNumberInsideFileNoneAtomic(Accumulator accumulator , String pathToFile) {
        this.accumulator = accumulator;
        try {

            this.fileReader = new FileReader(pathToFile);
        }catch (FileNotFoundException ex){
            System.out.println("File which path \"" + pathToFile + "\" wasn't found ");
            ex.printStackTrace();
        }
    }

    public void run(){

        Scanner scannerLine,scanner;
        String tempLine , doubleString;

        try{

            scanner = new Scanner(this.fileReader);
            while (scanner.hasNextLine()){

                tempLine = scanner.nextLine();
                scannerLine = new Scanner(tempLine);

                while (scannerLine.hasNext()){

                    if (scannerLine.hasNext("[0-9]+[,.][0-9]*")){

                        doubleString = scannerLine.next().replaceAll(",",".");
                        accumulator.addToSum(Double.parseDouble(doubleString));

                    }else if(scannerLine.hasNext("[0-9]+[0-9]*")){

                        accumulator.addToSum(Integer.parseInt(scannerLine.next()));
                    }else {

                        scannerLine.next();
                    }
                }
            }

            this.fileReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
