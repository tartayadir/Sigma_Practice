package FinalProjectTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> pathToFile = new ArrayList<>(Arrays.asList(
                "C://Users//Ярослав//IdeaProjects//Sigma_Practice//src//main//java//FinalProjectTest//File1",
                "C://Users//Ярослав//IdeaProjects//Sigma_Practice//src//main//java//FinalProjectTest//File2",
                "C://Users//Ярослав//IdeaProjects//Sigma_Practice//src//main//java//FinalProjectTest//File3"
        ));

        System.out.println("Average length of words in n files : " +
                Controller.AverageLengthWordsFromFiles(pathToFile));
    }
}

/*
Amount of word : 6329
Length word : 33252
5.253910570390267
 */
