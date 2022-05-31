package taskForLines;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {

        String path = "LINES";
        ArrayList<Point> listOfPoints = Controller.createListOfPoint(8);
        ArrayList<Line>  listOfLines  = Controller.createListOfLines(listOfPoints);
        ArrayList<HashMap<? extends PointAndLines , Integer>> list = new ArrayList<>();

        Controller.countingPointsBelongingToLines(listOfPoints,listOfLines);
        Controller.countingPassingThroughPoints(listOfPoints,listOfLines);

        list.add(Controller.createHashMapPoints(listOfPoints));
        list.add(Controller.createHashMapLines(listOfLines));

        Controller.writeToFileHashMap(list,path);

        Controller.test(path);
    }
}
