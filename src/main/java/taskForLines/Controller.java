package taskForLines;

import java.io.*;
import java.util.*;

public class Controller {

    public static HashMap<Point,Integer> createHashMapPoints(ArrayList<Point> pointArrayList){

        HashMap<Point , Integer> pointsMap = new HashMap<>();
        for (Point tempPoint : pointArrayList){
            pointsMap.put(tempPoint,tempPoint.getCountOfLiensPass());
        }
        return pointsMap;
    }

    public static HashMap<Line,Integer> createHashMapLines(ArrayList<Line> lineArrayList){
        HashMap<Line , Integer> linesMap = new HashMap<>();
        for (Line tempLine : lineArrayList){
            linesMap.put(tempLine,tempLine.getCountOfPointWhichHas());
        }

        return linesMap;
    }

    public static ArrayList<HashMap<? extends PointAndLines , Integer>> readFromFile(String path){

        ArrayList<HashMap<? extends PointAndLines , Integer>> list = null;

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {

            list = (ArrayList<HashMap<? extends PointAndLines, Integer>>) ois.readObject();

        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public static void writeToFileHashMap(ArrayList<HashMap<? extends PointAndLines , Integer>> list, String path) {

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(list);
            objectOutputStream.flush();
            objectOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void countingPassingThroughPoints(ArrayList<Point> pointArrayList,ArrayList<Line> lineArrayList){

        ListIterator<Point> pointIterator = pointArrayList.listIterator();
        ListIterator<Line> lineIterator;
        Point tempPoint;
        Line tempLine;

        while (pointIterator.hasNext()){
            lineIterator = lineArrayList.listIterator();
            tempPoint = pointIterator.next();
            while (lineIterator.hasNext()){
                tempLine = lineIterator.next();
                if(tempPoint.checkLienContainsPointAndAnother(tempLine)){
                    tempPoint.increaseCountOfLiensPass();
                }
            }
            pointIterator.set(tempPoint);
        }
    }

    public static void countingPointsBelongingToLines(ArrayList<Point> pointArrayList,ArrayList<Line> lineArrayList){

        ListIterator<Point> pointIterator = pointArrayList.listIterator();
        ListIterator<Line> lineIterator;
        Point tempPoint;
        Line tempLine;

        while (pointIterator.hasNext()){
            lineIterator = lineArrayList.listIterator();
            tempPoint = pointIterator.next();
            while (lineIterator.hasNext()){
                tempLine = lineIterator.next();
                tempLine.lineHasPoint(tempPoint,false);
                lineIterator.set(tempLine);
            }
        }
    }

    public static ArrayList<Line> createListOfLines(ArrayList<Point> pointArrayList){

        Set<Line> lineSet = new HashSet<>() ;
        int counterRunningLoop = 1;
        Iterator<Point> iterator ;
        Point p2;

        for (Point p1 : pointArrayList){

            iterator = pointArrayList.listIterator(counterRunningLoop);
            while (iterator.hasNext()){
                p2 = iterator.next();
                lineSet.add(new Line(p1,p2));
            }
            counterRunningLoop++;
        }

        return new ArrayList<>(lineSet);
    }

    public static ArrayList<Point> createListOfPoint(int sizeList){

        ArrayList<Point> list = new ArrayList<>();
        for (int i=0;i<sizeList;i++){
            list.add(createPoint());
        }
        return list;
    }

    public static Point createPoint(){
        int x = (int)((Math.random()*20)-10);
        int y = (int)((Math.random()*20)-10);
        return new Point(x,y);
    }

    public static void test(String path) {

        ArrayList<HashMap<? extends PointAndLines , Integer>> list = readFromFile(path);
        System.out.println(list);

        //HashMap<Point,Integer> hashMap1 = list.get(0);
        //HashMap<Line , Integer>  hashMap2  = list.get(1);

        //System.out.println(hashMap1);
        //System.out.println(hashMap2);

    }
}
