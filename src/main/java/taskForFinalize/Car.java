package taskForFinalize;

public class Car {

    private String model;

    public Car(String model) {
        this.model = model;
    }

    public void finalize(){

//      System.out.println("Car model : " + this.model);
//      Почему так не работает и не выводит модель , а так выводит ?????!!!!!

        System.out.print("Car model : " );
        System.out.println(this.model);
    }
}
