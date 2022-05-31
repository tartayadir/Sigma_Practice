package taskForSerialization;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Aircraft extends Vehicle implements Serializable {

    private String model;
    private int lengthOfFlying;
    transient private Chassis chassis;

    public Aircraft(int yearOfProduce, int speed, Engine engine, String model, int lengthOfFlying, Chassis chassis) {
        super(yearOfProduce, speed, engine);
        this.model = model;
        this.lengthOfFlying = lengthOfFlying;
        this.chassis = chassis;

    }

    public String getModel() {return model;}
    public void setModel(String model) {this.model = model;}

    public int getLengthOfFlying() {return lengthOfFlying;}
    public void setLengthOfFlying(int lengthOfFlying) {this.lengthOfFlying = lengthOfFlying;}

    public Chassis getChassis() {return chassis;}
    public void setChassis(Chassis chassis) {this.chassis = chassis;}

    private void writeObject(ObjectOutputStream objectOutputStream){

        try {

            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeInt(chassis.getWheel().getLoad());
            objectOutputStream.writeDouble(chassis.getWheel().getDiameter());
            objectOutputStream.writeInt(chassis.getCountOfWheels());
            objectOutputStream.writeInt(getYearOfProduce());
            objectOutputStream.writeInt(getSpeed());
            objectOutputStream.writeObject(getEngine().getType());
            objectOutputStream.writeInt(getEngine().getPower());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void readObject(ObjectInputStream objectInputStream){

        try {

            objectInputStream.defaultReadObject();
            this.chassis = new Chassis(new Wheel(objectInputStream.readInt(),objectInputStream.readDouble()),
                                                                                 objectInputStream.readInt());
            setYearOfProduce(objectInputStream.readInt());
            setSpeed(objectInputStream.readInt());
            setEngine(new Engine((String)objectInputStream.readObject(),objectInputStream.readInt()));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return  "Aircraft{" +
                "model='" + model + '\'' +
                ", lengthOfFlying=" + lengthOfFlying +
                ", countOfWheels= " + this.chassis.getCountOfWheels() +
                ", load=" + this.chassis.getWheel().getLoad() +
                ", diameter= " + this.chassis.getWheel().getDiameter() +
                ", yearOfProduce=" + getYearOfProduce() +
                ", speed=" + getSpeed() +
                ", typeOfEngine="
                + getEngine().getType() +
                ", power= " + getEngine().getPower()
           ;
    }
}
