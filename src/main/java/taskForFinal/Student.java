package taskForFinal;

import java.util.ArrayList;

public class Student {

    private final String name;
    private ArrayList<Integer> marks;

    public Student(){

        int option =(int)(Math.random()*10)%5;
        name = switch (option){
                 case 1 -> "Maksim";
                 case 2 -> "Erika";
                 case 3 -> "Anton";
                 default -> "Vlad";
        };

        marks = new ArrayList<>();
        for (int i=0;i<6;i++){
            marks.add((int)(Math.random()*10)%6);
        }
    }

    public Student(String name, ArrayList<Integer> marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }

    public String getName() {return name;}

    public ArrayList<Integer> getMarks() {return marks;}
    public void setMarks(ArrayList<Integer> marks) {this.marks = marks;}
}
