package taskForStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String pathToFile = "C://Users//Ярослав//IdeaProjects//Sigma_Practice//src//main//java//taskForStream//File";
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(
                1, -44, 22, -55, 44, 51, 1, 0, 32, -81, 234, -512, 1024, -2048));
        Map<Boolean, List<Integer>> parsingIntegersMap;

        String text = Controller.readTextFromFile(pathToFile);
        //List<String> upperCaseWordsList = Controller.toUpperCaseFirsLiter(text);
        Controller.sortedAndOutputSentencesOfText(text);
        //System.out.println("Words : " + upperCaseWordsList);

        parsingIntegersMap = Controller.parsingListOnNegativePositiveNumber(integers);
        View.viewPositiveNegativeNumbersList(parsingIntegersMap);
    }
}
