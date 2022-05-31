package taskForGenerics;

import java.util.Arrays;
import java.util.Objects;

public class Abiturient {

    private String name;
    private String lastname;
    private String patronymic;
    private String address;
    private int[] marks = new int[3];
    private double averageMark;

    public Abiturient(String name, String lastname, String patronymic, String address, int[] marks)
    {
        this.name = name;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.address = address;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Abiturient{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", marks=" + Arrays.toString(marks) +
                ", averageMark=" + averageMark +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Abiturient)) return false;
        Abiturient that = (Abiturient) o;
        return Double.compare(that.averageMark, averageMark) == 0 && Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname) && Objects.equals(patronymic, that.patronymic) && Objects.equals(address, that.address) && Arrays.equals(marks, that.marks);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, lastname, patronymic, address, averageMark);
        result = 31 * result + Arrays.hashCode(marks);
        return result;
    }
}
