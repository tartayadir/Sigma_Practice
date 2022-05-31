package taskForEnums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ControllerAndView {

    public static void sortListFests(ArrayList<Fest> list) {

        System.out.println("Choose the option of sorting(1 - sort by name fest , 2 - sort by city fest ," +
                " another number - sort by month) :");

        Scanner in = new Scanner(System.in);
        int option = in.nextInt();

        switch (option){
            case 1 :
                Collections.sort(list, new Comparator<Fest>() {
                    @Override
                    public int compare(Fest o1, Fest o2) {
                        int result = o1.getName().compareTo(o2.getName());
                        if (result !=0){
                            return result;
                        }else {
                            result = o1.getCity().compareTo(o2.getName());
                            if (result !=0){
                                return result;
                            }else {
                                result = o1.getMonthOfeYear().getNumberOfMount()-o2.getMonthOfeYear().getNumberOfMount();
                                return result;
                            }
                        }
                    }
                });
                break;
            case 2 :
                Collections.sort(list, new Comparator<Fest>() {
                    @Override
                    public int compare(Fest o1, Fest o2) {
                        int result =  o1.getCity().compareTo(o2.getName());
                        if (result !=0){
                            return result;
                        }else {
                            result = o1.getName().compareTo(o2.getName());
                            if (result !=0){
                                return result;
                            }else {
                                result = o1.getMonthOfeYear().getNumberOfMount()-o2.getMonthOfeYear().getNumberOfMount();
                                return result;
                            }
                        }
                    }
                });
                break;
            default:
                Collections.sort(list, new Comparator<Fest>() {
                    @Override
                    public int compare(Fest o1, Fest o2) {
                        int result = o1.getMonthOfeYear().getNumberOfMount()-o2.getMonthOfeYear().getNumberOfMount();
                        if (result !=0){
                            return result;
                        }else {
                            result = o1.getCity().compareTo(o2.getName());
                            if (result !=0){
                                return result;
                            }else {
                                result = o1.getName().compareTo(o2.getName());
                                return result;
                            }
                        }
                    }
                });

        }

        in.close();
    }

    public static void viewListFest(ArrayList<Fest> list){

        System.out.println("List of fests : ");
        for(Fest temp : list){
            System.out.println(temp);
        }
    }
}
