package taskForSerialization;

import java.io.*;

public class Ship extends Vehicle implements Externalizable {

    private int waterContent;
    private double length;
    private Boat boat;

    public Ship(int yearOfProduce, int speed, Engine engine, int waterContent, double length, Boat boat) {
        super(yearOfProduce, speed, engine);
        this.waterContent = waterContent;
        this.length = length;
        this.boat = boat;
    }

    public Ship(){}

    public int getWaterContent() {return waterContent;}
    public void setWaterContent(int waterContent) {this.waterContent = waterContent;}

    public double getLength() {return length;}
    public void setLength(double length) {this.length = length;}

    public Boat getBoat() {return boat;}
    public void setBoat(Boat boat) {this.boat = boat;}

    public void writeExternal(ObjectOutput objectOutputStream) {

        try {

            objectOutputStream.writeInt(this.waterContent);
            objectOutputStream.writeDouble(this.length);
            objectOutputStream.writeInt(this.boat.getCountOfPassengers());
            objectOutputStream.writeObject(this.boat.getMaterial());

            objectOutputStream.writeInt(getYearOfProduce());
            objectOutputStream.writeInt(getSpeed());
            objectOutputStream.writeObject(getEngine().getType());
            objectOutputStream.writeInt(getEngine().getPower());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void readExternal(ObjectInput objectInputStream) {

        try {

            this.waterContent = objectInputStream.readInt();
            this.length = objectInputStream.readDouble();
            this.boat = new Boat(objectInputStream.readInt(),(String) objectInputStream.readObject());

            setYearOfProduce(objectInputStream.readInt());
            setSpeed(objectInputStream.readInt());
            setEngine(new Engine((String)objectInputStream.readObject(),objectInputStream.readInt()));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Ship{" +
                "waterContent=" + waterContent +
                ", length=" + length +
                ", yearOfProduce=" + getYearOfProduce() +
                ", speed=" + getSpeed() +
                ", typeOfEngine="
                + getEngine().getType() +
                ", power= " + getEngine().getPower() +
                " countOfPassengers=" + boat.getCountOfPassengers() +
                ", material='" + boat.getMaterial() + '\'' +
                '}';
    }
}
