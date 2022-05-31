package taskForLambads2;

import java.util.ArrayList;
import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {

//      ArrayList<Car>[] arrOfListOfCar = new ArrayList[6];

        ArrayList<Car> list1 = createdListOfCar(10);
        task2(list1,170);

    }

    public static void task2(ArrayList<Car> listOfCar, int rate){

        BiFunction<ArrayList<Car>,Integer,ArrayList<Car>> elementsHigherThanTheValue = (ArrayList<Car> list, Integer value) -> {

            ArrayList<Car> resultList = new ArrayList<>();

            for(Car temp:list){
                if (temp.getMaxSpeed() > value){
                    resultList.add(temp);
                }
            }
            return resultList;
        };

        BiFunction<ArrayList<Car>,Integer,ArrayList<Car>> elementsLowerThanTheValue = (ArrayList<Car> list, Integer value) -> {

            ArrayList<Car> resultList = new ArrayList<>();

            for(Car temp:list){
                if (temp.getMaxSpeed() < value){
                    resultList.add(temp);
                }
            }
            return resultList;
        };

        ArrayList<Car> listOfElementsHigherThanTheValue = elementsHigherThanTheValue.apply(listOfCar,rate);
        ArrayList<Car> listOfElementsLowerThanTheValue = elementsLowerThanTheValue.apply(listOfCar,rate);

        System.out.println("Cars with have max speed lower than " + rate + " : +\n" + listOfElementsLowerThanTheValue);
        System.out.println("Cars with have max speed higher than " + rate + " : +\n" + listOfElementsHigherThanTheValue);

    }

    public static ArrayList<Car> createdListOfCar(int size){

        ArrayList<Car> resultList = new ArrayList<>();
        for (int i=0;i<size;i++){
            resultList.add(new Car(150+(int)(Math.random()*(101))));
        }

        return resultList;
    }
}
