package threeTaskForInheritance;

import static java.util.GregorianCalendar.*;
import java.util.Calendar;
import java.util.Date;
import  java.util.GregorianCalendar;
import java.util.Scanner;

public class Controller {

    public static void inputBirthday(GregorianCalendar model){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите свою дату рожедения (день месяц год) : ");
        int day = scanner.nextInt() , month = scanner.nextInt(), year = scanner.nextInt();

        model.set(year,month-1,day);
    }

    public static void setBirthday(GregorianCalendar model,int day,int month,int year){
        model.set(year,month,day);
    }

    public static int[] getNextDayOfWeekForNext5Year(GregorianCalendar model){

        GregorianCalendar today = new GregorianCalendar() , tempModel = new GregorianCalendar(today.get(YEAR) , model.get(MONTH) , model.get(DAY_OF_MONTH));
        int[] result = {0,0,0,0,0};

        for (int i=0;i<5;i++){

            tempModel.roll(YEAR,1);
            result[i] = tempModel.get(DAY_OF_WEEK);
        }

        return result;
    }

    public static long differenceBetweenBwoDates(GregorianCalendar firstDate , GregorianCalendar secondaryDate ){

        Date firstDate1 = firstDate.getTime();
        Date secondaryDate2 = secondaryDate.getTime();
        long diffInMillies = firstDate1.getTime() - secondaryDate2.getTime();
        return diffInMillies/1000/60/60/24;
    }


}
