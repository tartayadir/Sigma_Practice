package taskForFinalize;

public class Main {

    public static void main(String[] args) {

       Car car1 = new Car("BMW");
       Car car2 = new Car("Opel");
       Car car3 = new Car("Audi");

       car1 = null;
       car2 = null;
       car3 = null;

        System.gc();
    }
}
