package taskForConcurrentCollections;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class RepeatingWordCounter implements Runnable{

    private ConcurrentHashMap<String, Long> wordsAndAmount;
    private FileReader fileReader;

    public RepeatingWordCounter(ConcurrentHashMap<String, Long> wordsAndAmount , String filePath) {
        this.wordsAndAmount = wordsAndAmount;
        try {

            this.fileReader = new FileReader(filePath);
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public void run(){

        Scanner fileScanner = new Scanner(this.fileReader);
        Scanner lineScanner;
        String temp;

        while (fileScanner.hasNext()){

            lineScanner = new Scanner(fileScanner.nextLine());
            while(lineScanner.hasNext()){

                temp = lineScanner.next();
                if (temp.length()>1 && temp.charAt(0) == temp.charAt(temp.length()-1)){
                    this.wordsAndAmount.compute(temp, (key,value) -> value == null ? 1 : ++value);
                }
            }
        }
    }
}
