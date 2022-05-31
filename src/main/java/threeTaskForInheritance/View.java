package threeTaskForInheritance;

import java.util.GregorianCalendar;

public class View {

    public static void viewNextDayOfWeekForNext5Year(GregorianCalendar model){

        int[] arrOfDays = Controller.getNextDayOfWeekForNext5Year(model);
        System.out.println("Список дней недели на которые припадает ваше день рождения следущии 5 лет : ");
        for (int i =0 ;i<5 ;i++){

            switch (arrOfDays[i]){

                case 1 :
                    System.out.print("Sunday "); break;
                case 2 :
                    System.out.print("Monday "); break;
                case 3 :
                    System.out.print("Tuesday "); break;
                case 4 :
                    System.out.print("Wednesday "); break;
                case 5 :
                    System.out.print("Thursday "); break;
                case 6 :
                    System.out.print("Friday "); break;
                case 7 :
                    System.out.print("Saturday "); break;
            }

            System.out.print(i==4 ? "\n" : ", ");
        }
    }

    public static void viewDifferenceBetweenStartAndEndOfSecondaryWar(){
        GregorianCalendar start = new GregorianCalendar() , end = new GregorianCalendar();
        start.set(1939,8,1);
        end.set(1945,8,2);
        long difference = Controller.differenceBetweenBwoDates(start,end);
        System.out.println("Промежуток между началом и концом второй мировой войны в днях : " + (difference+2));
    }

}
