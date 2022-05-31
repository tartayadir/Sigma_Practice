package taskForStream;

import java.util.List;
import java.util.Map;

public class View {

    public static void viewPositiveNegativeNumbersList(Map<Boolean, List<Integer>> numbersMap){

        System.out.println("Negative numbers : " + numbersMap.get(true));
        System.out.println("Positive numbers : " + numbersMap.get(false));
    }

}
