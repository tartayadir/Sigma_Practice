package taskForCollector;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String pathToFile = "C://Users//Ярослав//IdeaProjects//Sigma_Practice//src//main//java//taskForCollector//File";
        List<Integer> integerList = new ArrayList<>(Arrays.asList(
                2, 3, -1, -34, 21, 109, 230, -219, 23, 74, 51, -81, 0
        ));

        integerList = Controller.replaceMinMax(integerList);
        System.out.println(integerList);

        integerList = Controller.elementsMoreThenAverage(integerList);
        System.out.println(integerList);

        String text = Controller.readTextFromFile(pathToFile);
        Map<Long,Long> map = Controller.differenceBetweenAmountOfVowelsAndConsonantLetters(text);
        System.out.println(map);

    }
}
