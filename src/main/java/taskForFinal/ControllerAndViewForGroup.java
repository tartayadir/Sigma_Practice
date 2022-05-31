package taskForFinal;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class ControllerAndViewForGroup {

    public static void fillingInTheGroup(Group group , int sizeOfGroup){

        for (int i=0;i<sizeOfGroup;i++){
            addStudentInGroup(group,new Student());
        }
    }

    public static void addStudentInGroup(@NotNull Group group , Student student){
        if (group.isTrainingIsCompleted()){
            System.out.println("Обучение завершенно , вы не можете добавить студента в группу.");
        }else {
            group.getStudents().add(student);
        }
    }

//  Отдельный метод для проверки неизменяемости коллекции и вызова исключения
//--------------------------------------------------------------------------------------------
    public static void addStudentInGroupConsoleTest(@NotNull Group group , Student student){

            group.getStudents().add(student);
    }
//--------------------------------------------------------------------------------------------

    public static void completedTraining(@NotNull Group group){

        group.setTrainingIsCompleted(true);
        group.setStudents(Collections.unmodifiableList(group.getStudents()));
    }

    public static void viewGroup(@NotNull Group group){

        System.out.println("Members of group : ");
        for (Student student : group.getStudents()){
            System.out.println(student.toString());
        }
    }
}
