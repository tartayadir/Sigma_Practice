package taskForFinal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group {

    private List<Student> students;
    private boolean trainingIsCompleted;

    public Group(){
        students = new ArrayList<>();
    }
    public Group(ArrayList<Student> students) {
        this.students = students;
    }

    public boolean isTrainingIsCompleted() {return trainingIsCompleted;}
    public void setTrainingIsCompleted(boolean trainingIsCompleted) {this.trainingIsCompleted = trainingIsCompleted;}

    public List<Student> getStudents() {return students;}
    public void setStudents(List<Student> students) {this.students = students;}
}
