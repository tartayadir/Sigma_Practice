package taskForWaitNotify;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderWriter {

    private FileReader fileReader;
    private boolean wasCalledCounter = false;
    private int counterSpace = 0;
    private String pathToFile;

    public FileReaderWriter(String pathToFile) {
        try {
            this.fileReader = new FileReader(pathToFile);
        }catch (FileNotFoundException fileNotFoundException){
            fileNotFoundException.printStackTrace();
        }
        this.pathToFile = pathToFile;
    }

    public int countSpace() {

        String line;

        synchronized (this){

            while (wasCalledCounter){
                try {
                    wait();
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            }

            System.out.println("Counting name : " + pathToFile);

            Scanner scannerFile = new Scanner(fileReader);

            while (scannerFile.hasNext()){

                line = scannerFile.nextLine();
                counterSpace += line.length() - line.replaceAll(" ","").length();
            }

            wasCalledCounter = true;

            try {
                fileReader.close();
            }catch (IOException ioe){
                ioe.printStackTrace();
            }

            notifyAll();
            return this.counterSpace;
        }
    }

    public void toUpperCaseFirstOrLastLetters(){

        synchronized (this){
            while(!wasCalledCounter) {
                try {
                    wait();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }

            try {

                System.out.println("Refactor name : " + pathToFile);

                this.fileReader = new FileReader(this.pathToFile);

                String text = new String();
                Scanner scannerFile = new Scanner(this.fileReader);
                Scanner scannerLine ;
                String tempString;

                while (scannerFile.hasNext()){

                    scannerLine = new Scanner(scannerFile.nextLine());

                    while (scannerLine.hasNext()){

                        tempString = scannerLine.next();

                        if (this.counterSpace % 2 == 0)
                        {
                            text += (tempString.substring(0,1).toUpperCase() +  tempString.substring(1,tempString.length()));
                        }else {
                            text += (tempString.substring(0,tempString.length()-1) +
                                    tempString.substring(tempString.length()-1, tempString.length()).toUpperCase());
                        }

                        text += " ";
                    }

                    wasCalledCounter = false;
                    text+="\n";
                }

                this.fileReader.close();

                FileWriter fileWriter = new FileWriter(this.pathToFile);
                fileWriter.write(text);
                fileWriter.flush();
                fileWriter.close();

            }catch (IOException ioException){
                ioException.printStackTrace();
            }

            notifyAll();
        }
    }

    public FileReader getFileReader() {return fileReader;}
    public int getCounterSpace() {return counterSpace;}
    public String getPathToFile() {return pathToFile;}

    public void addToCounterSpace(int counterSpace) {
        synchronized (this){
            this.counterSpace += counterSpace;
        }
    }
}
