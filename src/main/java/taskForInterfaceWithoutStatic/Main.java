package taskForInterfaceWithoutStatic;

import taskForInterfaceWithComarator.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean checkNumber = true;

        ArrayList<taskForInterfaceWithComarator.Person> listOfPerson= new ArrayList<>();
        for (int i = 0;i<8;i++){
            listOfPerson.add(createPerson());
        }

        System.out.println("Введите число для сортировки (1 - по регону ,2 - по году рождения , 3 - по полу или любое другое для сортировки по имени) : ");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        System.out.println("Перед сортировкой  : " + listOfPerson);

        switch (option){
            case "1" :
                Collections.sort(listOfPerson,new Comparator(){

                    @Override
                    public int compare(Object o1, Object o2) {

                        int result = ((Person)o1).getRegion().compareTo(((Person)o2).getRegion());
                        if (result!=0){
                            return result;
                        }else {
                            result =((Person)o1).getName().compareTo(((Person)o2).getName());
                            if (result!=0){
                                return result;
                            }else {
                                result = Boolean.compare(((Person)o1).isMale(),(((Person)o2).isMale()));
                                if (result!=0){
                                    return result;
                                }else {
                                    result = ((Person)o1).getBirthYear() - (((Person)o2).getBirthYear());
                                    return result;
                                }
                            }
                        }
                    }
                }); checkNumber = false; break;
            case "2" :
                Collections.sort(listOfPerson,new Comparator(){

                    @Override
                    public int compare(Object o1, Object o2) {

                        int result = ((Person)o1).getBirthYear() - (((Person)o2).getBirthYear());
                        if (result!=0){
                            return result;
                        }else {
                            result = Boolean.compare(((Person)o1).isMale(),(((Person)o2).isMale()));
                            if (result!=0){
                                return result;
                            }else {
                                result =((Person)o1).getName().compareTo(((Person)o2).getName());
                                if (result!=0){
                                    return result;
                                }else {
                                    result = ((Person)o1).getRegion().compareTo(((Person)o2).getRegion());
                                    return result;
                                }
                            }
                        }
                    }
                });checkNumber = false; break;
            case "3" :
                Collections.sort(listOfPerson, new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {

                        int result = Boolean.compare(((Person)o1).isMale(),(((Person)o2).isMale()));
                        if (result!=0){
                            return result;
                        }else {
                            result =((Person)o1).getName().compareTo(((Person)o2).getName());
                            if (result!=0){
                                return result;
                            }else {
                                result = ((Person)o1).getRegion().compareTo(((Person)o2).getRegion());
                                if (result!=0){
                                    return result;
                                }else {
                                    result = ((Person)o1).getBirthYear() - (((Person)o2).getBirthYear());
                                    return result;
                                }
                            }
                        }
                    }
                }); checkNumber = false ; break;
        }
        if (checkNumber){
            Collections.sort(listOfPerson,new Comparator(){

                @Override
                public int compare(Object o1, Object o2) {

                    int result =((Person)o1).getName().compareTo(((Person)o2).getName());

                    if (result!=0){
                        return result;
                    }else {
                        result = ((Person)o1).getRegion().compareTo(((Person)o2).getRegion());

                        if (result!=0){
                            return result;
                        }else {
                            result = ((Person)o1).getBirthYear() - (((Person)o2).getBirthYear());

                            if (result!=0){
                                return result;
                            }else {
                                result = Boolean.compare(((Person)o1).isMale(),(((Person)o2).isMale()));
                                return result;
                            }
                        }
                    }
                }

            });
        }

        System.out.println("После сортировки  : " +listOfPerson);
    }

    public static taskForInterfaceWithComarator.Person createPerson(){

        int birthYear = (int)(Math.random()*16)+1990;
        boolean isMale = true;

        String name = "";
        switch ((int)(Math.random()*10)*31%7){
            case 1 : name = "Maksim";break;
            case 2 : name = "Erika"; isMale = false;break;
            case 3 : name = "Anton";break;
            case 4 : name = "Anna"; isMale = false;break;
            case 5 : name = "Lisa"; isMale = false;break;
            case 0 : name =  "Vlad"; break;
            case 6 : name =  "Roma"; break;
        };
        String region = "";
        switch ((int)(Math.random()*10)*31%5){
            case 1 : region = "Dnepropetrovsk"; break;
            case 2 : region = "Kharkov"; break;
            case 3 : region = "Kiev"; break;
            case 0 : region = "Ternopil"; break;
            case 4 : region = "Odessa"; break;
        };

        return new Person(name,region,birthYear,isMale);
    }
}
