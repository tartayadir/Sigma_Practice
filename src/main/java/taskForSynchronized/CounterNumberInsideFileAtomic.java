package taskForSynchronized;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.atomic.DoubleAdder;

public class CounterNumberInsideFileAtomic implements Runnable{

    private DoubleAdder doubleAdder;
    private FileReader fileReader;

    public CounterNumberInsideFileAtomic(DoubleAdder doubleAdder , String pathToFile) {
        this.doubleAdder = doubleAdder;
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
                        doubleAdder.add(Double.parseDouble(doubleString));

                    }else if(scannerLine.hasNext("[0-9]+[0-9]*")){

                        doubleAdder.add(Integer.parseInt(scannerLine.next()));
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
