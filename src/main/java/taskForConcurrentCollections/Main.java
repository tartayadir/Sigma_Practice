package taskForConcurrentCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> pathsOfFile = new ArrayList<>(Arrays.asList(
               "C://Users//Ярослав//IdeaProjects//Sigma_Practice//src//main//java//taskForConcurrentCollections//File1",
               "C://Users//Ярослав//IdeaProjects//Sigma_Practice//src//main//java//taskForConcurrentCollections//File2",
               "C://Users//Ярослав//IdeaProjects//Sigma_Practice//src//main//java//taskForConcurrentCollections//File3"
        ));

        ConcurrentHashMap<String, Long> hashMapWords = Controller.wordsNumberOfRepeatedWords(pathsOfFile);
        System.out.println("Hash map : " + hashMapWords);

    }
}















