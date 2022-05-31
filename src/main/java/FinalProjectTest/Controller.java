package FinalProjectTest;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.LongAccumulator;

public class Controller {

    public static Double AverageLengthWordsFromFiles(List<String> pathsToFiles){

        LongAccumulator counterAmountOfWord = new LongAccumulator(Long::sum, 0);
        LongAccumulator counterOfLengthWord = new LongAccumulator(Long::sum, 0);
        CountDownLatch countDownLatch = new CountDownLatch(pathsToFiles.size());

        pathsToFiles.
                parallelStream().
                forEach(s -> new WordsCounter(s, counterAmountOfWord, counterOfLengthWord, countDownLatch));

        try {
            countDownLatch.await();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        return counterOfLengthWord.doubleValue()/counterAmountOfWord.doubleValue();
    }
}

