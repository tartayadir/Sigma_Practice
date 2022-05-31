package taskForMain;

import java.util.ArrayList;

public class Model {

    private ArrayList<String> weekDays , marks , planets ;

    {
        weekDays = new ArrayList<>();
        weekDays.add("Monday");
        weekDays.add("Tuesday");
        weekDays.add("Wednesday");
        weekDays.add("Thursday");
        weekDays.add("Friday");
        weekDays.add("Saturday");
        weekDays.add("Sunday");

        marks = new ArrayList<>();
        marks.add("Unsatisfactory");
        marks.add("Unsatisfactory");
        marks.add("Unsatisfactory");
        marks.add("Satisfactory");
        marks.add("Good");
        marks.add("Excellent");

        planets = new ArrayList<>();
        planets.add("Mercury");
        planets.add("Venus");
        planets.add("Earth");
        planets.add("Mars");
        planets.add("Jupiter");
        planets.add("Saturn");
        planets.add("Uran");
        planets.add("Neptune");
    }

    public ArrayList<String> getWeekDays() {
        return weekDays;
    }

    public ArrayList<String> getMarks() {
        return marks;
    }

    public ArrayList<String> getPlanets() {
        return planets;
    }
}
