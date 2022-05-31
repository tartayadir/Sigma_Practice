package taskForSynchronized;

import java.util.ArrayList;
import java.util.concurrent.atomic.DoubleAdder;

public class Controller {

    public static void countSumOfAllNumbersInFiles(ArrayList<String> namesFiles,Accumulator accumulatorForSum){

        ArrayList<Thread> numberInsideFileArrayList =
                new ArrayList<>();

        for (String nameOfFile : namesFiles) {
            numberInsideFileArrayList.add(new Thread(new CounterNumberInsideFileNoneAtomic(accumulatorForSum,nameOfFile)));
        }

        for(Thread tread : numberInsideFileArrayList){
            tread.start();
        }
        for(Thread tread : numberInsideFileArrayList){
            try {
                tread.join();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }

    public static void countSumOfAllNumbersInFiles(ArrayList<String> namesFiles, DoubleAdder doubleAdder){

        ArrayList<Thread> numberInsideFileArrayList =
                new ArrayList<>();

        for (String nameOfFile : namesFiles) {
            numberInsideFileArrayList.add(new Thread(new CounterNumberInsideFileAtomic(doubleAdder,nameOfFile)));
        }

        for(Thread tread : numberInsideFileArrayList){
            tread.start();
        }
        for(Thread tread : numberInsideFileArrayList){
            try {
                tread.join();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
