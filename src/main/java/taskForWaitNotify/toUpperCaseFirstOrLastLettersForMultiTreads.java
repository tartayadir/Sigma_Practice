package taskForWaitNotify;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class toUpperCaseFirstOrLastLettersForMultiTreads extends toUpperCaseFirstOrLastLetters implements Runnable{

    private final FileReaderWriter fileReaderWriter;

    public toUpperCaseFirstOrLastLettersForMultiTreads(FileReaderWriter fileReaderWriter) {
        this.fileReaderWriter = fileReaderWriter;
        new Thread(this).start();
    }

    @Override
    public void run() {

        synchronized (this.fileReaderWriter){

            try {

                String text = new String();
                Scanner scannerFile = new Scanner(new FileReader(this.fileReaderWriter.getPathToFile()));
                Scanner scannerLine ;
                String tempString;
                int amountOfSpace = this.fileReaderWriter.getCounterSpace();

                while (scannerFile.hasNext()){

                    scannerLine = new Scanner(scannerFile.nextLine());

                    while (scannerLine.hasNext()){

                        tempString = scannerLine.next();

                        if (amountOfSpace % 2 == 0)
                        {
                            text += (tempString.substring(0,1).toUpperCase() +  tempString.substring(1,tempString.length()));
                        }else {
                            text += (tempString.substring(0,tempString.length()-1) +
                                    tempString.substring(tempString.length()-1, tempString.length()).toUpperCase());
                        }

                        text += " ";
                    }

                    text+="\n";
                }

                this.fileReaderWriter.getFileReader().close();

                FileWriter fileWriter = new FileWriter(this.fileReaderWriter.getPathToFile());
                fileWriter.write(text);
                fileWriter.flush();
                fileWriter.close();

            }catch (IOException ioException){
                ioException.printStackTrace();
            }
        }
    }
}
