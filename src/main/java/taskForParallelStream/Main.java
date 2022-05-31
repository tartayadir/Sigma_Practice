package taskForParallelStream;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Integer[] array = Controller.createIntegerArray(10000000);

        Controller.filteringAndSortedParallelStream(array);
        Controller.filteringAndSortedNoParallelStream(array);

        Map<Integer, Long> map1 = Controller.filteringAndSortedParallelStream(array);
        Map<Integer, Long> map2 = Controller.filteringAndSortedNoParallelStream(array);

        System.out.println(map1.equals(map2));
        //System.out.println(Controller.filteringAndSortedNoParallelStream(array));
    }
}
