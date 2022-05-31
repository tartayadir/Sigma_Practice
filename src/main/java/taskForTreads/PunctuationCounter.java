package taskForTreads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.Callable;

public class PunctuationCounter implements Callable<Pair<File,Integer>> {

    private FileReader fileReader;
    private String nameFile;

    public PunctuationCounter(String inputFileName){
        try {
            this.nameFile = inputFileName;
            this.fileReader = new FileReader(inputFileName);
        }catch (FileNotFoundException fileNotFoundException){
            System.out.println("File " + inputFileName + " wasn't founded ");
            fileNotFoundException.printStackTrace();
        }
    }

    public Pair<File,Integer> call(){

        int countOfPunctual = 0 ;

        try {

            Scanner scanner = new Scanner(this.fileReader);
            while (scanner.hasNextLine()){

                String tempStr = scanner.nextLine();
                countOfPunctual += tempStr.length() - tempStr.replaceAll("[!.,;:?\\-]","").length();

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        this.closeInputFile();

        return new Pair<>(new File(this.nameFile) , countOfPunctual);
    }

    public void closeInputFile(){

        try {

            this.fileReader.close();

        }catch (IOException iioException){
            System.out.println("File could not be closed");
            iioException.printStackTrace();
        }
    }
}
