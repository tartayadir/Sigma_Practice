package taskForLambds1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        System.out.println("Task 1.1 ");
        task1_1();
        System.out.println("Task 1.2 ");
        task1_2();
    }

    public static void task1_2(){

        Function<int [],Integer > averageIntoArray = (int[] mas) -> {

            int sum = 0;

            for(int temp:mas){
                sum+=temp;
            }
            Integer average = (sum/mas.length);
            return average;
        };

        BiFunction<int[],int[],ArrayList<Integer>> numberBetweenAverageOfTwoArray = (int[] mas1,int[] mas2) -> {

            ArrayList<Integer> result = new ArrayList<>();

            int average1 = averageIntoArray.apply(mas1);
            int average2 = averageIntoArray.apply(mas2);

            int averageMax = Math.max(average1,average2);
            int averageMin = Math.min(average1,average2);

            for (int temp:mas1){
                if (temp > averageMin && temp <averageMax){
                    result.add(temp);
                }
            }

            for (int temp:mas2){
                if (temp > averageMin && temp <averageMax){
                    result.add(temp);
                }
            }

            return result;
        };

        int[] arr1 = new int[15],arr2 = new int[15];
        for (int i=0;i<15;i++) {
            arr1[i] = ((int) (Math.random() * 20) - 10);
        }
        System.out.println("Array 1 : " + Arrays.toString(arr1));

        for (int i=0;i<15;i++) {
            arr2[i] = ((int) (Math.random() * 20) - 10);
        }
        System.out.println("Array 2 : " + Arrays.toString(arr2));

        System.out.println("Average in 1 array : " + averageIntoArray.apply(arr1));
        System.out.println("Average in 2 array : " + averageIntoArray.apply(arr2));

        ArrayList<Integer> result = numberBetweenAverageOfTwoArray.apply(arr1,arr2);
        System.out.println("Number between average in 1 and 2 arrays : " + result);
    }

    public static void task1_1(){

        Function<int [],ArrayList> negativeNumber = (int[] mas) -> {

            ArrayList<Integer> result = new ArrayList<>();

            for(int temp:mas){
                if (temp <= 0){
                    result.add(temp);
                }
            }
            return result;
        };

        Function<int [],ArrayList> positiveNumber = (int[] mas) -> {

            ArrayList<Integer> result = new ArrayList<>();

            for(int temp:mas){
                if (temp > 0){
                    result.add(temp);
                }
            }
            return result;
        };

        Function<int [],ArrayList> pairedNumber = (int[] mas) -> {

            ArrayList<Integer> result = new ArrayList<>();

            for(int temp:mas){
                if (temp % 2 == 0){
                    result.add(temp);
                }
            }
            return result;
        };

        Function<int [],ArrayList> notPairedNumber = (int[] mas) -> {

            ArrayList<Integer> result = new ArrayList<>();

            for(int temp:mas){
                if (temp % 2 != 0){
                    result.add(temp);
                }
            }
            return result;
        };

        int[] arr = new int[15];
        for (int i=0;i<15;i++) {
            arr[i] = ((int) (Math.random() * 20) - 10);
        }

        System.out.println("Array : " + Arrays.toString(arr));

        ArrayList<Integer> listOfNegativeNumber = negativeNumber.apply(arr);
        System.out.println("Negative number in array : " + listOfNegativeNumber);

        ArrayList<Integer> listOfPositiveNumber = positiveNumber.apply(arr);
        System.out.println("Positive number in array : " + listOfPositiveNumber);

        ArrayList<Integer> listOfPairedNumber = pairedNumber.apply(arr);
        System.out.println("Paired number in array : " + listOfPairedNumber);

        ArrayList<Integer> listOfNotPairedNumber = notPairedNumber.apply(arr);
        System.out.println("Not paired number in array : " + listOfNotPairedNumber);
    }
}
