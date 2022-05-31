package taskForSerialization;

public class Chassis {

    transient private Wheel wheel;
    private int countOfWheels;

    public Chassis(Wheel wheel, int countOfWheels) {
        this.wheel = wheel;
        this.countOfWheels = countOfWheels;
    }

    public Wheel getWheel() {return wheel;}
    public void setWheel(Wheel wheel) {this.wheel = wheel;}

    public int getCountOfWheels() {return countOfWheels;}
    public void setCountOfWheels(int countOfWheels) {this.countOfWheels = countOfWheels;}

    @Override
    public String toString() {
        return "Chassis{" +
                "wheel=" + wheel +
                ", countOfWheels=" + countOfWheels +
                '}';
    }
}
