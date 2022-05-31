package taskForTreads;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception{

        ArrayList<String> fileNames = new ArrayList<>(Arrays.asList(
                "C://Users//Ярослав//IdeaProjects//Sigma_Practice//src//main//java//taskForTreads//File1",
                "C://Users//Ярослав//IdeaProjects//Sigma_Practice//src//main//java//taskForTreads//File2",
                "C://Users//Ярослав//IdeaProjects//Sigma_Practice//src//main//java//taskForTreads//File3"

        ));
        TreeSet<Pair<File,Integer>> pairTreeSet =
                Controller.countingPunctuationMarksInFilesAndSortingMultiTread(fileNames);
        Controller.countingPunctuationMarksInFilesAndSortingSingleTread(fileNames);
        TreeSet<File> fileTreeSet = Controller.treeSetPairFileAndAmountOfPunctuationToTreeSetFile(pairTreeSet);
    }
}
