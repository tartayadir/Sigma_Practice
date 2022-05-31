package taskForSerialization;

public class Vehicle implements Comparable<Vehicle> {

    private transient int yearOfProduce , speed;
    Engine engine;

    public Vehicle(){}

    public Vehicle(int yearOfProduce, int speed, Engine engine) {
        this.yearOfProduce = yearOfProduce;
        this.speed = speed;
        this.engine = engine;
    }

    public int getYearOfProduce() {return yearOfProduce;}
    public void setYearOfProduce(int yearOfProduce) {this.yearOfProduce = yearOfProduce;}

    public int getSpeed() {return speed;}
    public void setSpeed(int speed) {this.speed = speed;}

    public Engine getEngine() {return engine;}
    public void setEngine(Engine engine) {this.engine = engine;}

    public int compareTo(Vehicle obj){

        return this.yearOfProduce - obj.getYearOfProduce();
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "yearOfProduce=" + yearOfProduce +
                ", speed=" + speed +
                ", engine=" + engine +
                '}';
    }
}
