package taskForStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Controller {

    public static String readTextFromFile(String pathToFile){

        StringBuilder text = new StringBuilder();
        try {

            Scanner scanner = new Scanner(new FileReader(pathToFile));
            while(scanner.hasNext()){

                text.append(scanner.nextLine()).append("\n");
            }

            scanner.close();
        }catch (FileNotFoundException fileNotFoundException){

            fileNotFoundException.printStackTrace();
        }

        return text.toString();
    }

    public static void sortedAndOutputSentencesOfText(String text){

        Arrays.stream(text.split("[.?!] ")).forEach(s -> {

            Arrays.stream(s.split(" "))
                    .sorted(Comparator.comparing(s1 -> s1.length()))
                    .forEach(s2 -> System.out.print(s2.replaceAll("\n","") + " "));
            System.out.print(".\n");
        });
    }

    public static List<String> toUpperCaseFirsLiter(String text){

        return Arrays.stream(text.split(" "))
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
                .collect(Collectors.toList());
    }

    public static Map<Boolean,List<Integer>> parsingListOnNegativePositiveNumber(ArrayList<Integer> integers){

        Map<Boolean,List<Integer>> resultMap = new HashMap<>();

        resultMap.put(true, integers.stream().filter(n -> n<0).toList());
        resultMap.put(false, integers.stream().filter(n -> n>=0).toList());

        return resultMap;
    }
}
