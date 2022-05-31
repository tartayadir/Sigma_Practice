package taskForEnums;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ArrayList<Fest> listFests = new ArrayList<>(Arrays.asList(
                new Fest("Tomorrowland","Bom",YearMonth.MARCH),
                new Fest("Burning man","Black-Rock",YearMonth.DECEMBER),
                new Fest("Holli","New Delhi",YearMonth.FEBRUARY),
                new Fest("October Fest","Munich",YearMonth.OCTOBER),
                new Fest("Carnival in Rio de Janeiro","Rio de Janeiro",YearMonth.AUGUST),
                new Fest("Up Helly Aa","Lerwick",YearMonth.JANUARY)
        ));

        ControllerAndView.sortListFests(listFests);
        ControllerAndView.viewListFest(listFests);
    }
}
