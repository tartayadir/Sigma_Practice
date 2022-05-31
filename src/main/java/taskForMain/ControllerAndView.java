package taskForMain;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerAndView {

    public static void inputDate(Model model){

        Scanner scanner = new Scanner(System.in);
        //ArrayList<Integer> enumOfInputDates = new ArrayList<>();
        String inputString = scanner.nextLine();
        String[] arr = inputString.split(" ");
        String option = arr[0];

        switch (option){
            case "WEEK_DAYS" : definitionWeekDays(model,arr); break;
            case "MARKS" : definitionMarks(model,arr); break;
            case "PLANETS" : definitionPlanets(model,arr); break;
            default:
                System.out.println("Некоректные входные данные !!");
        }

    }

    public static void definitionMarks(Model model , String[] arr){

        ArrayList<String> arrayList = model.getMarks();
        for (int i=1;i< arr.length;i++){

            int index = Integer.parseInt(arr[i]);
            viewResult(arrayList.get(index));
        }
    }

    public static void definitionPlanets(Model model , String[] arr){

        ArrayList<String> arrayList = model.getPlanets();
        for (int i=1;i< arr.length;i++){

            int index = Integer.parseInt(arr[i]);
            viewResult(arrayList.get(index-1));
        }
    }
    public static void definitionWeekDays(Model model , String[] arr){

        ArrayList<String> arrayList = model.getWeekDays();
        for (int i=1;i< arr.length;i++){

            int index = Integer.parseInt(arr[i]);
            viewResult(arrayList.get(index-1));
        }
    }

    public static void viewResult(String message){

        System.out.println(message);
    }
}
