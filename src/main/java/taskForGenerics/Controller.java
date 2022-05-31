package taskForGenerics;

import java.util.*;

public class Controller {

    public static <T, V extends T> Map <? extends T,Integer> identicalValuesAndNumberOfRepetitions(ArrayList<T> list , V[] array){

        Map<T,Integer> resultMap = new HashMap<>();
        int countOfCopy = 0;

        for (T tempListValue : list){
            countOfCopy = 0;
            for(V tempArrayValue : array){

                if (tempListValue.equals(tempArrayValue)){
                    countOfCopy++;
                }
            }

            if (countOfCopy!=0){
                resultMap.put(tempListValue,countOfCopy);
            }

        }

        return resultMap;
    }

    public static <T ,V extends T > void addAllRecurringElements(ArrayList<T> list , V [] array){

        ArrayList<T> listTemp = new ArrayList<>();

        for (V tempValueArray : array){

            for(T tempValueList : list){

                if (tempValueArray.equals(tempValueList)){
                    listTemp.add(tempValueArray);
                }
            }
        }

        list.addAll(listTemp);
    }

    public static void test1SameTypeObjectsSameTypeOfContainer(){

        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(
                new Tiger(23,400,"India"),new Tiger(31,544,"Africa"),
                new Tiger(55,560,"America"),new Tiger(32,344,"Africa")
        ));

        Animal[] arrayAnimals = {
                new Tiger(23,400,"India"),new Tiger(15,544,"India"),
                new Tiger(45,344,"Brazilian"),new Tiger(45,344,"Brazilian"),
        };

        System.out.println("----------------------------------Test 1----------------------------------");
        System.out.println("-------------same type objects same type of containers--------------------");

        System.out.println("Arrays :\n" + Arrays.toString(arrayAnimals));
        System.out.println("ArrayList :\n " + animalArrayList);
        System.out.println("Search same object and count of amount of copy : \n" +
                Controller.identicalValuesAndNumberOfRepetitions(animalArrayList,arrayAnimals));

        addAllRecurringElements(animalArrayList,arrayAnimals);
        System.out.println("List after add all different element " + animalArrayList);
    }

    public static void test2DifferentTypeObjectsSameTypeOfContainer(){

        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(
                new Tiger(23,400,"India"),new BengalTiger(31,544,"Africa"),
                new Lion(55,560,"America"),new Lion(32,344,"Africa"),
                new BengalTiger(43,404,"America"),new Tiger(41,544,"Africa"),
                new Tiger(10,460,"India"),new Lion(21,300,"India"),
                new Animal(18, 350 , "China"), new Animal(45,340,"Brazilian")
        ));

        Animal[] arrayAnimals = {
                new Tiger(23,400,"India"),new BengalTiger(32,544,"India"),
                new Tiger(44,401,"America"),new Animal(45,340,"Brazilian"),
                new Lion(32,344,"Africa"), new BengalTiger(43,333,"Africa"),
                new Lion(43,211,"America"), new Tiger(10,460,"India")
                ,new Tiger(23,400,"India"), new Animal(45,340,"Brazilian")
        };

        System.out.println("----------------------------------Test 2----------------------------------");
        System.out.println("-------------different type of objects same type of containers------------");

        System.out.println("Arrays :\n" + Arrays.toString(arrayAnimals));
        System.out.println("ArrayList :\n " + animalArrayList);
        System.out.println("Search same object and count of amount of copy : \n" +
                Controller.identicalValuesAndNumberOfRepetitions(animalArrayList,arrayAnimals));

        addAllRecurringElements(animalArrayList,arrayAnimals);
        System.out.println("List after add all different element " + animalArrayList);
    }

    public static void test3DifferentTypeObjectsDifferentTypeOfContainer(){

        ArrayList<Tiger> animalArrayList = new ArrayList<>(Arrays.asList(
                new Tiger(23,400,"India"),new Tiger(31,544,"Africa"),
                new BengalTiger(55,560,"America"),new Tiger(32,344,"Africa"),
                new Tiger(43,404,"America"),new BengalTiger(41,544,"Africa")
        ));

        BengalTiger[] arrayAnimals = {
                new BengalTiger(23,400,"India"),new BengalTiger(32,544,"India"),
                new BengalTiger(44,401,"America"),new BengalTiger(45,340,"Brazilian"),
                new BengalTiger(32,344,"Africa"), new BengalTiger(43,333,"Africa"),
        };

        System.out.println("----------------------------------Test 3----------------------------------");
        System.out.println("----------different type of objects different type of containers----------");

        System.out.println("Arrays :\n" + Arrays.toString(arrayAnimals));
        System.out.println("ArrayList :\n " + animalArrayList);
        System.out.println("Search same object and count of amount of copy : \n" +
                Controller.identicalValuesAndNumberOfRepetitions(animalArrayList,arrayAnimals));

        addAllRecurringElements(animalArrayList,arrayAnimals);
        System.out.println("List after add all different element " + animalArrayList);
    }


}
