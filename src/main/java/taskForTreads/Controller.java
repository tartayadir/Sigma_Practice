package taskForTreads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.*;

public class Controller {

    public static TreeSet<File> treeSetPairFileAndAmountOfPunctuationToTreeSetFile(TreeSet<Pair<File,Integer>> pairTreeSet){

        TreeSet<File> fileTreeSet = new TreeSet<>();

        for (Pair<File,Integer> tempPair : pairTreeSet){

            //System.out.println(tempPair.getSecondElement());
            fileTreeSet.add(tempPair.getFirstElement());
        }

        return fileTreeSet;
    }

    public static TreeSet<Pair<File,Integer>> countingPunctuationMarksInFilesAndSortingSingleTread(ArrayList<String> arrayListFileNames){

        Comparator<Pair<File,Integer>> comparatorForFile = (o1, o2) -> o1.getSecondElement() - o2.getSecondElement();
        TreeSet<Pair<File,Integer>> resultTreeSet = new TreeSet<>(comparatorForFile);
        long startTime ,endTime ;

        startTime = System.nanoTime();
        for (String nameFile : arrayListFileNames){

            resultTreeSet.add(countingPunctuationMarksInFile(nameFile));
        }
        endTime = System.nanoTime();

        System.out.println(" Name of method was called : countingPunctuationMarksInFilesAndSortingSingleTread");
        System.out.println(" Time spent on method execution (single-threaded mode) : " + (endTime - startTime));


        for(Pair<File,Integer> tempPair : resultTreeSet){
            System.out.println(tempPair.getSecondElement());
        }

        return resultTreeSet;
    }

    public static Pair<File,Integer> countingPunctuationMarksInFile(String inputFileName){

        int countOfPunctual = 0 ;
        FileReader fileReader ;

        try {

            fileReader = new FileReader(inputFileName);

            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()){

                String tempStr = scanner.nextLine();
                countOfPunctual += tempStr.length() - tempStr.replaceAll("[!.,;:?\\-]","").length();
                fileReader.close();
            }

        }catch (FileNotFoundException fileNotFoundException){

            System.out.println("File " + inputFileName + " wasn't founded ");
            fileNotFoundException.printStackTrace();

        }catch (Exception e){
            e.printStackTrace();
        }

        return new Pair<>(new File(inputFileName) , countOfPunctual);
    }

    public static TreeSet<Pair<File,Integer>> countingPunctuationMarksInFilesAndSortingMultiTread(ArrayList<String> arrayListFileNames){

        Comparator<Pair<File,Integer>> comparatorForFile = (o1, o2) -> o1.getSecondElement() - o2.getSecondElement();

        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Callable<Pair<File,Integer>>> callableArrayList = new ArrayList<>();
        TreeSet<Pair<File,Integer>> resultTreeSet = new TreeSet<>(comparatorForFile);
        long startTime = 0 ,endTime = 0 ;

        for(String nameOfFile : arrayListFileNames){
            callableArrayList.add(new PunctuationCounter(nameOfFile));
        }

        try {

            startTime = System.nanoTime();
            List<Future<Pair<File,Integer>>> result = executorService.invokeAll(callableArrayList);
            executorService.shutdown();
            endTime = System.nanoTime();

            for(Future<Pair<File,Integer>> future : result){

                resultTreeSet.add(future.get());
            }

        }catch (ExecutionException | InterruptedException ex){
            ex.printStackTrace();
        }

        System.out.println(" Name of method which was called : countingPunctuationMarksInFilesAndSortingMultiTread");
        System.out.println(" Time spent on method execution (multi-threaded mode) : " + (endTime - startTime));


        for(Pair<File,Integer> tempPair : resultTreeSet){
            System.out.println(tempPair.getSecondElement());
        }

        return resultTreeSet;
    }
}
