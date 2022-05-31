package taskForSerialization;

public class Boat {

    private int countOfPassengers;
    private String material;

    public Boat(int countOfPassengers, String material) {
        this.countOfPassengers = countOfPassengers;
        this.material = material;
    }

    public int getCountOfPassengers() {return countOfPassengers;}
    public void setCountOfPassengers(int countOfPassengers) {this.countOfPassengers = countOfPassengers;}

    public String getMaterial() {return material;}
    public void setMaterial(String material) {this.material = material;}

}
