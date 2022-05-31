package taskForFiles;

import java.util.*;

public class Controller {

    public static void writeListInFile(InputFile file , ArrayList<Bottle> listBottles) throws Exception{

        String fName = file.getFName();
        file.close();

        OutputFile fileOut = new OutputFile(fName);

        for (Bottle bottle : listBottles){
            fileOut.write(bottle.getBottle() + " " + bottle.getVolume() + " " +  bottle.getMaterial());
        }
        fileOut.close();
    }

    public static void closeListFiles(ArrayList<InputFile> fileArrayList) throws Exception{
        for (InputFile file : fileArrayList){
            file.close();
        }
    }

    public static InputFile createInputFile(String fName) throws Exception{
        InputFile inputFile = new InputFile(fName);
        return inputFile;
    }

    public static ArrayList<InputFile> crateListInputFiles(List<String> listNameFiles) throws Exception{

        ArrayList<InputFile> listFiles = new ArrayList<>();
        for(String tempFName : listNameFiles){
            listFiles.add(createInputFile(tempFName));
        }
        return listFiles;
    }

    public static void distributionByFilesListFiles(ArrayList<InputFile> inputFileArrayList) throws Exception{

        final OutputFile outputFileBottlesOfWhichVolumeSmallerThan0_5 = new OutputFile(
                "C:/Users/Ярослав/IdeaProjects/Sigma_Practice/src/main/java/taskForFiles" +
                        "/bottlesOfWhichVolumeSmallerThan0.5");
        final OutputFile bottlesOfWhichVolumeBetween0_51And0_99 = new OutputFile(
                "C:/Users/Ярослав/IdeaProjects/Sigma_Practice/src/main/java/taskForFiles" +
                        "/bottlesOfWhichVolumeBetween0.51And0.99");
        final OutputFile outputFileBottlesOfWhichVolumeBiggerThan1_0 = new OutputFile(
                "C:/Users/Ярослав/IdeaProjects/Sigma_Practice/src/main/java/taskForFiles/" +
                        "bottlesOfWhichVolumeBiggerThan1.0");

        for (InputFile inputFile : inputFileArrayList){
            distributionByFiles(inputFile , outputFileBottlesOfWhichVolumeSmallerThan0_5,
                    bottlesOfWhichVolumeBetween0_51And0_99 , outputFileBottlesOfWhichVolumeBiggerThan1_0);
        }

        outputFileBottlesOfWhichVolumeSmallerThan0_5.close();
        bottlesOfWhichVolumeBetween0_51And0_99.close();
        outputFileBottlesOfWhichVolumeBiggerThan1_0.close();
    }

    public static ArrayList<Bottle> makeListBottles(InputFile file) throws Exception{

        String tempLine = "";
        ArrayList<Bottle> resultList = new ArrayList<>();
        while ((tempLine = file.readLine())!=null){

            String[] arrWords = tempLine.split(" ");
            Bottle bottle = new Bottle((Double.parseDouble(arrWords[1])),arrWords[0],arrWords[2]);
            resultList.add(bottle);
        }
        return resultList;
    }


    private static void sortOutputFileByVolume(InputFile file) throws Exception {

        ArrayList<Bottle> listBottles = makeListBottles(file);
        Collections.sort(listBottles,new Comparator(){

            public int compare(Object o1,Object o2){

                int result = Double.compare(((Bottle)o1).getVolume() ,((Bottle)o2).getVolume());
                if (result!=0){
                    return result;
                }else{
                    result = ((Bottle)o1).getMaterial().compareTo(((Bottle)o2).getMaterial());
                    if (result!=0){
                        return result;
                    }else{
                        result = ((Bottle)o1).getBottle().compareTo(((Bottle)o2).getBottle());
                        return result;
                    }
                }
            }
        });

        writeListInFile(file,listBottles);
    }

    private static void sortOutputFileByBottle(InputFile file) throws Exception {

        ArrayList<Bottle> listBottles = makeListBottles(file);
        Collections.sort(listBottles,new Comparator(){

            public int compare(Object o1,Object o2){
                int  result = ((Bottle)o1).getBottle().compareTo(((Bottle)o2).getBottle());
                if (result!=0){
                    return result;
                }else{
                    result = Double.compare(((Bottle)o1).getVolume() ,((Bottle)o2).getVolume());
                    if (result!=0){
                        return result;
                    }else{
                        result = ((Bottle)o1).getMaterial().compareTo(((Bottle)o2).getMaterial());
                        return result;
                    }
                }
            }
        });
        writeListInFile(file,listBottles);
    }

    private static void sortOutputFileByMaterial(InputFile file) throws Exception {

        ArrayList<Bottle> listBottles = makeListBottles(file);
        Collections.sort(listBottles,new Comparator(){

            public int compare(Object o1,Object o2){
                int result = ((Bottle)o1).getMaterial().compareTo(((Bottle)o2).getMaterial());
                if (result!=0){
                    return result;
                }else{
                    result = Double.compare(((Bottle)o1).getVolume() ,((Bottle)o2).getVolume());
                    if (result!=0){
                        return result;
                    }else{
                        result = ((Bottle)o1).getBottle().compareTo(((Bottle)o2).getBottle());
                        return result;
                    }
                }
            }
        });
        writeListInFile(file,listBottles);
    }

    public static void sortOutputFiles() throws Exception{

        List<String> listNameOfOutputFiles = new ArrayList<>(Arrays.asList(
                "C:/Users/Ярослав/IdeaProjects/Sigma_Practice/src/main/java/taskForFiles" +
                        "/bottlesOfWhichVolumeSmallerThan0.5",
                "C:/Users/Ярослав/IdeaProjects/Sigma_Practice/src/main/java/taskForFiles" +
                        "/bottlesOfWhichVolumeBetween0.51And0.99",
               "C:/Users/Ярослав/IdeaProjects/Sigma_Practice/src/main/java/taskForFiles" +
                         "/bottlesOfWhichVolumeBiggerThan1.0"));
        ArrayList<InputFile> listOutputFiles = crateListInputFiles(listNameOfOutputFiles);

        Scanner in = new Scanner(System.in);
        System.out.println("Введите число для сортировики файлов (1 - по Bottle , 2 - по Material ," +
                "дюбое другое число - по Value : ");
        int option = in.nextInt();
        switch (option){
            case 1 :
                for (InputFile file : listOutputFiles){
                    sortOutputFileByBottle(file);
                }
                break;
            case 2 :
                for (InputFile file : listOutputFiles){
                    sortOutputFileByMaterial(file);
                }
                break;
            default:
                for (InputFile file : listOutputFiles){
                    sortOutputFileByVolume(file);
                }
        }

       closeListFiles(listOutputFiles);
    }

    public static void distributionByFiles(InputFile inputFile , OutputFile outputFileBotSmallThan0_5,
                                       OutputFile outputFileBotBetween0_51And0_99, OutputFile outputFileBotBigThan1_0)
                                                                                                       throws Exception{

        String line;
        inputFile.readLine();
        while ((line = inputFile.readLine())!=null){
            String[] arrWords = line.split(" ");
            double volume = Double.parseDouble(arrWords[2]);
            line = arrWords[1] + " " + arrWords[2] + " " + arrWords[3];
            if (volume <= 0.5){
                outputFileBotSmallThan0_5.write(line);
            }else if (volume <= 0.99){
                outputFileBotBetween0_51And0_99.write(line);
            }else {
                outputFileBotBigThan1_0.write(line);
            }
        }
    }
}

