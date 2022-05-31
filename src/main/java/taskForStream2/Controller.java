package taskForStream2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Controller {

    public static int[] concatArrays(int[] arr1, int[] arr2){

        return IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).distinct().toArray();
    }

    public static long averageValueAndAmountOfElementMoreThenValue(int[] arr){

        double averageValue = Arrays.stream(arr).average().getAsDouble();
        System.out.println("Average value : " + averageValue);

        long countValueMoreThanAverage = Arrays.stream(arr).filter((n) -> n>averageValue).count();
        System.out.println("Amount of element which more then " + averageValue + " : " + countValueMoreThanAverage);

        return countValueMoreThanAverage;
    }

    public static int[] removeReapingMinMax(int[] arr){

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        return Arrays.stream(arr).
                filter((n) -> n !=max)
                .filter((n) -> n!=min)
                .toArray();
    }
}
