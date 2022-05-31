package taskForSerialization;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Controller {

    public static ArrayList<Ship> DiSerializableListOfShips(String nameOfInputFile ) throws IOException , ClassNotFoundException{

        ArrayList<Ship> listOfShips = new ArrayList<>();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nameOfInputFile));

        while(true){
            try{
                listOfShips.add((Ship) ois.readObject());
            }catch (EOFException e){
                break;
            }
        }
        ois.close();
        return listOfShips;
    }

    public static void SerializableListOfShips(String nameOfOutputFile , ArrayList<Ship> listOfShips) throws IOException{

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nameOfOutputFile));
        for (Ship ship : listOfShips){

            oos.writeObject(ship);
        }

        oos.flush();
        oos.close();
    }

    public static ArrayList<Aircraft> DiSerializableListOfAircraft(String nameOfInputFile ) throws IOException , ClassNotFoundException{

        ArrayList<Aircraft> listOfAircraft = new ArrayList<>();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nameOfInputFile));

        while(true){
            try{
                listOfAircraft.add((Aircraft) ois.readObject());
            }catch (EOFException e){
                break;
            }
        }
        ois.close();
        return listOfAircraft;
    }

    public static void SerializableListOfAircraft(String nameOfOutputFile , ArrayList<Aircraft> listOfAircraft) throws IOException{

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nameOfOutputFile));
        for (Aircraft aircraft : listOfAircraft){

            oos.writeObject(aircraft);
        }

        oos.flush();
        oos.close();
    }

    public static void viewListOfShips(ArrayList<Ship> listOfShip){

        System.out.println("List of ships : ");
        for (Ship tempShip : listOfShip){
            System.out.println(tempShip);
        }

        System.out.println();
    }

    public static void viewListOfAircraft(ArrayList<Aircraft> listOfAircraft){

        System.out.println("List of aircraft : ");
        for (Aircraft tempAircraft : listOfAircraft){
            System.out.println(tempAircraft);
        }

        System.out.println();
    }

    public static ArrayList<Ship> getSortedListOfShips(){

        ArrayList<Ship> ships = new ArrayList<>(Arrays.asList(
                new Ship(1995,150,new Engine("DE",1234),
                        2000,122.2,new Boat(10,"Wood")),
                new Ship(2013,330,new Engine("GE",1004),
                        3000,709,new Boat(20,"Wood")),
                new Ship(2000,212,new Engine("DE",1234),
                        2600,160.23,new Boat(7,"Iron")),
                new Ship(1987,170,new Engine("GE",1134),
                        3211,100.9,new Boat(12,"Wood"))));
        Collections.sort(ships);
        return ships;
    }

    public static ArrayList<Aircraft> getSortedListOfAircraft(){

        ArrayList<Aircraft> plans = new ArrayList<>(Arrays.asList(
                new Aircraft(2001,732,new Engine("ARE",500),
                        "Boeing 737 Classic",1100,new Chassis(new Wheel(400,4),4)),
                new Aircraft(2005,890,new Engine("RE",600),
                        "Embraer",1500,new Chassis(new Wheel(800,4),6)),
                new Aircraft(1999,552,new Engine("ARE",788),
                        "Boeing 737 Classic",1330,new Chassis(new Wheel(400,4),5)),
                new Aircraft(2010,666,new Engine("RE",434),
                        "Embraer",900,new Chassis(new Wheel(400,4),5))));
        Collections.sort(plans);
        return plans;
    }
}
