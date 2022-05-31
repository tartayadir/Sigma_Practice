package taskForSerialization;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        ArrayList<Aircraft> plans = Controller.getSortedListOfAircraft();
        ArrayList<Ship> ships = Controller.getSortedListOfShips();
        String nameFileForWriteListAircraft = "C://Users//Ярослав//IdeaProjects//Sigma_Practice" +
                "//src//main//java//taskForSerialization//FileForWriteListAircraft";
        String nameFileForWriteListShips = "C://Users//Ярослав//IdeaProjects//Sigma_Practice" +
                "//src//main//java//taskForSerialization//FileForWriteListShips";


        Controller.SerializableListOfAircraft(nameFileForWriteListAircraft, plans);
        //Controller.viewListOfAircraft(plans);
        plans = Controller.DiSerializableListOfAircraft(nameFileForWriteListAircraft);
        //Controller.viewListOfAircraft(plans);

        Controller.SerializableListOfShips(nameFileForWriteListShips,ships);
        //Controller.viewListOfShips(ships);
        ships = Controller.DiSerializableListOfShips(nameFileForWriteListShips);
        //Controller.viewListOfShips(ships);

    }
}
