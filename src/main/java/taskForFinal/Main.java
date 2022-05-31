package taskForFinal;

public class Main {

    public static void main(String[] args) {

        Group group = new Group();
        ControllerAndViewForGroup.fillingInTheGroup(group,10);
        ControllerAndViewForGroup.completedTraining(group);
        ControllerAndViewForGroup.addStudentInGroup(group,new Student());
        ControllerAndViewForGroup.addStudentInGroupConsoleTest(group,new Student());

        ControllerAndViewForGroup.viewGroup(group);
    }
}
