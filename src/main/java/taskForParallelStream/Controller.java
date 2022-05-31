package taskForParallelStream;

import java.util.*;
import java.util.function.Function;
import static java.util.stream.Collectors.*;

public class Controller {

    public static Map<Integer, Long> filteringAndSortedParallelStream(Integer[] arr){

        List<Integer> integerList = Arrays.asList(arr);

        Long time1 = System.currentTimeMillis();
        TreeMap<Integer, Long> treeMap =  new TreeMap<>(
         integerList.parallelStream().
                filter(n -> n % 2 == 0).
                collect(groupingBy(
                        Function.identity(),
                        counting()
                )));
        Long time2 = System.currentTimeMillis();
        System.out.println("Time spend in parallel stream : " + (time2 - time1));
        return treeMap;
    }

    public static Map<Integer, Long> filteringAndSortedNoParallelStream(Integer[] arr){

        List<Integer> integerList = Arrays.asList(arr);

        Long time1 = System.currentTimeMillis();
        TreeMap<Integer, Long> treeMap =  new TreeMap<>(
                integerList.stream().
                        filter(n -> n % 2 == 0).
                        collect(groupingBy(
                                Function.identity(),
                                counting()
                        )));
        Long time2 = System.currentTimeMillis();
        System.out.println("Time spend in stream : " + (time2 - time1));
        return treeMap;
    }

    public static Integer[] createIntegerArray( int size){

        Integer[] arr = new Integer[size];
        for(int i = 0; i<size; i++ ){
            arr[i] = ( (int)(Math.random()*200 - 100));
        }

        return arr;
    }

}
