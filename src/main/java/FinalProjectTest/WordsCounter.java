package FinalProjectTest;

import java.io.*;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.LongAccumulator;

public class WordsCounter extends Thread{

    private final String pathToFile;
    private final LongAccumulator counterAmountOfWord;
    private final LongAccumulator counterOfLengthWord;
    private final CountDownLatch countDownLatch;

    public WordsCounter(String pathToFile, LongAccumulator counterAmountOfWord, LongAccumulator counterOfLengthWord,
                        CountDownLatch countDownLatch) {

        this.pathToFile = pathToFile;
        this.counterOfLengthWord = counterOfLengthWord;
        this.counterAmountOfWord = counterAmountOfWord;
        this.countDownLatch = countDownLatch;

        new Thread(this).start();
    }

    @Override
    public void run() {

        Scanner fileScanner;
        Scanner lineScanner;

        try {

            fileScanner = new Scanner(new FileReader(this.pathToFile));
            while (fileScanner.hasNext()){

                lineScanner = new Scanner(fileScanner.nextLine());
                while (lineScanner.hasNext()){

                    counterOfLengthWord.accumulate(lineScanner.
                            next().
                            replaceAll("[:;()0-9\\s?.,!]", "").
                            length()
                    );

                    counterAmountOfWord.accumulate(1);
                }
            }
        }catch (FileNotFoundException fileNotFoundException){
            fileNotFoundException.printStackTrace();
        }

        this.countDownLatch.countDown();
    }
}
