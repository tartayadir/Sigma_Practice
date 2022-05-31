package threeTaskForInheritance;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {


        GregorianCalendar birthday = new GregorianCalendar() ;
        Controller.inputBirthday(birthday);
        View.viewNextDayOfWeekForNext5Year(birthday);
        View.viewDifferenceBetweenStartAndEndOfSecondaryWar();
    }
}
