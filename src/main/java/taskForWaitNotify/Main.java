package taskForWaitNotify;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> pathsOfFile = new ArrayList<>(Arrays.asList(
                "C://Users//Ярослав//IdeaProjects//Sigma_Practice//src//main//java//taskForWaitNotify//File1",
                "C://Users//Ярослав//IdeaProjects//Sigma_Practice//src//main//java//taskForWaitNotify//File2",
                "C://Users//Ярослав//IdeaProjects//Sigma_Practice//src//main//java//taskForWaitNotify//File3"
        ));

        Controller.countSpaceAndToUpperCaseLetterDuoTreads(pathsOfFile);
        //Controller.countSpaceAndToUpperCaseLetterMultiTreads(pathsOfFile);

    }
}