package taskForFiles;

import java.util.*;

public class Main {

///                                        ?????
    public static void main(String[] args) throws Exception{

        List<String> listNameOfInputFiles = new ArrayList<>(Arrays.asList(
                "C://Users//Ярослав//IdeaProjects//Sigma_Practice//src//main//java//taskForFiles//File1",
                "C://Users//Ярослав//IdeaProjects//Sigma_Practice//src//main//java//taskForFiles//File2",
                "C://Users//Ярослав//IdeaProjects//Sigma_Practice//src//main//java//taskForFiles//File3"));

        ArrayList<InputFile> listInputFiles = Controller.crateListInputFiles(listNameOfInputFiles);
        Controller.distributionByFilesListFiles(listInputFiles);
        Controller.sortOutputFiles();
        Controller.closeListFiles(listInputFiles);

    }
}
