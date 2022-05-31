package taskForSerialization;

public class Wheel {

    private int load;
    private double diameter;

    public Wheel(int load, double diameter) {
        this.load = load;
        this.diameter = diameter;
    }

    public int getLoad() {return load;}
    public void setLoad(int load) {this.load = load;}

    public double getDiameter() {return diameter;}
    public void setDiameter(double diameter) {this.diameter = diameter;}

}
