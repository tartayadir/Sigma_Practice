package taskForConcurrentCollections;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class Controller {

    public static ConcurrentHashMap<String,Long> wordsNumberOfRepeatedWords(ArrayList<String> pathsToFiles){

        ConcurrentHashMap<String, Long> resultHashMap = new ConcurrentHashMap<>();
        ArrayList<Thread> threadArrayList = new ArrayList<>();

        for(String temp : pathsToFiles){
            threadArrayList.add(new Thread(new RepeatingWordCounter(resultHashMap, temp)));
        }

        for (Thread thread : threadArrayList){
            thread.start();
        }

        for (Thread thread : threadArrayList){
            try {
                thread.join();
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }

        return resultHashMap;
    }
}
