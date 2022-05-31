package taskForWaitNotify;

import java.util.ArrayList;

public class Controller {

    public static void countSpaceAndToUpperCaseLetterDuoTreads(ArrayList<String> pathsToFiles){

        ArrayList<FileReaderWriter> fileReaderWriterArrayList = new ArrayList<>();
        for(String temp : pathsToFiles){

            fileReaderWriterArrayList.add(new FileReaderWriter(temp));
        }

        for(FileReaderWriter tempFRW : fileReaderWriterArrayList){
            new CounterSpaceForDuoThreads(tempFRW);
            new toUpperCaseFirstOrLastLettersForDuoTreads(tempFRW);
        }

    }

    public static void countSpaceAndToUpperCaseLetterMultiTreads(ArrayList<String> pathsToFiles){

        ArrayList<FileReaderWriter> fileReaderWriterArrayList = new ArrayList<>();

        for(String path : pathsToFiles){

            fileReaderWriterArrayList.add(new FileReaderWriter(path));
        }

        ArrayList<Thread> counterSpaceForMultiThreads = new ArrayList<>();
        for(FileReaderWriter temp : fileReaderWriterArrayList){

            counterSpaceForMultiThreads.add(new Thread(new CounterSpaceForMultiThreads(temp)));
        }

        for(Thread thread : counterSpaceForMultiThreads){

            try {
                thread.join();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        ArrayList<Thread> forMultiTreads = new ArrayList<>();
        for(FileReaderWriter temp : fileReaderWriterArrayList){

            forMultiTreads.add(new Thread(new toUpperCaseFirstOrLastLettersForMultiTreads(temp)));
        }

        for(Thread thread : forMultiTreads){

            try {
                thread.join();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}
