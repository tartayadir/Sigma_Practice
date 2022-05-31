package taskForSynchronized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.DoubleAdder;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> namesOfFile = new ArrayList<>(Arrays.asList(
                "C://Users//Ярослав//IdeaProjects//Sigma_Practice//src//main//java//taskForSynchronized//File1",
                "C://Users//Ярослав//IdeaProjects//Sigma_Practice//src//main//java//taskForSynchronized//File2",
                "C://Users//Ярослав//IdeaProjects//Sigma_Practice//src//main//java//taskForSynchronized//File3"
        ));
        Accumulator accumulatorForSum = new Accumulator();
        DoubleAdder doubleAdder = new DoubleAdder();

        Controller.countSumOfAllNumbersInFiles(namesOfFile,accumulatorForSum);
        System.out.println(accumulatorForSum.getSum());

        Controller.countSumOfAllNumbersInFiles(namesOfFile,doubleAdder);
        System.out.println(doubleAdder.sum());
    }
}
