package taskForCollector;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class Controller {

    public static String readTextFromFile(String pathToFile){

        StringBuilder text = new StringBuilder();
        try {

            Scanner scanner = new Scanner(new FileReader(pathToFile));
            while(scanner.hasNext()){

                text.append(scanner.nextLine());
            }

            scanner.close();
        }catch (FileNotFoundException fileNotFoundException){

            fileNotFoundException.printStackTrace();
        }

        return text.toString();
    }

    public static List<Integer> replaceMinMax(List<Integer> integerList){

        IntSummaryStatistics intSummaryStatistics = integerList.stream()
                .collect(
                summarizingInt(Integer::intValue));
        Integer max = intSummaryStatistics.getMax();
        Integer min = intSummaryStatistics.getMin();
        integerList = integerList.stream().
                map(n ->{
                    if(n.equals(max)) {
                        return min;
                    }
                    if(n.equals(min))
                        return max;
                    return n;
                }).collect(Collectors.toList());
        return integerList;
    }

    public static List<Integer> elementsMoreThenAverage(List<Integer> integerList){

        int averageValue = integerList.stream().collect(averagingInt(Integer::intValue)).intValue();
        integerList = integerList.stream().
                filter(n -> Integer.compare(averageValue, n) < 1 ).
                toList();
        return integerList;
    }

    public static Map<Long, Long> differenceBetweenAmountOfVowelsAndConsonantLetters(String text){

        text = text.replaceAll("\\d+.\\d+","").replaceAll("[,\\d(){}°\\s-*]","");
        Map<Long, Long> resultMap = new HashMap<>();
        char[] chars = text.toCharArray();

        IntStream.
                range(0, chars.length).
                mapToObj(i -> chars[i]).
                forEach(
                        character -> {
                            if(character.equals('.')){

                                long tempN = Counter.n;
                               resultMap.put(tempN , (Counter.countConsonant - Counter.countVowels));
                               Counter.n ++;
                               Counter.countConsonant = Long.valueOf(0);
                               Counter.countVowels = Long.valueOf(0);
                            }else {

                                if(character.toString().replaceAll("[euioa]", "").length()!=0){
                                    Counter.countConsonant ++;
                                }else {
                                    Counter.countVowels++;
                                }
                            }
                        }
                );
        return resultMap;
    }

    static class Counter{
        static Long countVowels = 0L,
                countConsonant = 0L,
                n = 1L;
    }
}
/*

 return Arrays.stream(text.split("[.?!]")).
                filter(s -> s.length()>0).
                collect(toMap(
                        Counter::add,
                        (String s) ->
                                s.replaceAll("[aeuio]", "").length()-
                                s.replaceAll("[^aeuio]", "").length()
                ));

 */