package taskForInterfaceWithComarator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<taskForInterfaceWithoutStatic.Person> listOfPerson= new ArrayList<>();
        for (int i = 0;i<8;i++){
            listOfPerson.add(createPerson());
        }

        System.out.println("Введите число для сортировки (1 - по регону ,2 - по году рождения , 3 - по полу или любое другое для сортировки по имени) : ");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        System.out.println(listOfPerson);

        switch (option){
            case "1" :
                Collections.sort(listOfPerson,new ComparatorByRegion()); break;
            case "2" :
                Collections.sort(listOfPerson,new ComparatorByBirthYear()); break;
            case "3" :
                Collections.sort(listOfPerson,new ComparatorByMale()); break;
            default :
                Collections.sort(listOfPerson,new ComparatorByName());
        }

        System.out.println(listOfPerson);
    }

    public static taskForInterfaceWithoutStatic.Person createPerson(){

        int birthYear = (int)(Math.random()*16)+1990;
        boolean isMale = true;

        String name ;
        switch ((int)(Math.random()*10)*31%7){
            case 1 : name = "Maksim";break;
            case 2 : name = "Erika"; isMale = false;break;
            case 3 : name = "Anton";break;
            case 4 : name = "Anna"; isMale = false;break;
            case 5 : name = "Lisa"; isMale = false;break;
            default : name =  "Vlad";
        };
        String region = switch ((int)(Math.random()*10)*17%5){
            case 1 -> "Dnepropetrovsk";
            case 2 -> "Kharkov";
            case 3 -> "Kiev";
            default -> "Ternopil";
        };

        return new taskForInterfaceWithoutStatic.Person(name,region,birthYear,isMale);
    }
}


