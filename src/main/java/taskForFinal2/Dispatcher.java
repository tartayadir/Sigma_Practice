package taskForFinal2;

import java.util.*;

public class Dispatcher {

    public static void main(String[] args) {
        List<Integer> marks = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));    //fast way to initialize all marks of all students
        List<Student> students = new ArrayList<>(Arrays.asList(new Student("name1", marks), new Student("name2", marks),
                new Student("name3", marks), new Student("name4", marks), new Student("name5", marks))
        );

        final Group group = new Group(students);
        group.addStudent(new Student("Alla" , marks));
        group.endOfStudying();
        group.addStudent(new Student("Maksim" , marks));
        System.out.println(group.toString());
//      group = new Group(students);

/*
        System.out.println("Before modifying:\n" + group);

        group.endOfStudying();

        students.add(new Person("NEW", marks));                          //Won't modify group.students

        //UnsupportedOperationException:
//        group.getStudents().add(new Person("NEW1", marks));
//        group.getStudents().set(0, new Person("NEW2", marks));
//        group.getStudents().get(0).getMarks().add(100);
//        group.getStudents().get(0).getMarks().set(0, 100);

        System.out.println("After modifying:\n" + group);     */                  //The same as the previous output
    }
}

        class Student {

            final private String name;
            private List<Integer> marks;

            public Student(String name, List<Integer> marks) {
                this.name = name;
                this.marks = marks;
            }

           public void saveResults() {
            marks = Collections.unmodifiableList(marks);
            }

            @Override
            public String toString() {
                return "Person{" +
                        "name='" + name + '\'' +
                        ", marks=" + marks +
                        "}\n";
            }

            public String getName() {return name;}
            public List<Integer> getMarks() {return marks;}
        }

        class Group {

            private List<Student> students;
            private boolean trainingIsCompleted;

            public Group(List<Student> students) {
                this.students = new ArrayList<>(students);
            }

            public void addStudent(Student student){
                if (!trainingIsCompleted){
                    students.add(student);
                }else {
                    System.out.println("Обучение завершенно , вы не можете добавить студента в группу.");
                }
            }

            public void endOfStudying() {
                trainingIsCompleted = true;
                this.students = Collections.unmodifiableList(new ArrayList<>(students));
                for (Student s : students) {
                    s.saveResults();
                }
            }

            public List<Student> getStudents() {return students;}

            @Override
            public String toString() {
                return "Group{" + students + '}';
            }
        }