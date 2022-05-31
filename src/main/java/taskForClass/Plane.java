package taskForClass;

import java.util.Objects;

class Plane extends Vehicle {
    private int flyHeight;
    private int numberOfEngines;

    public Plane(String model, String owner, int price, int produceYear, double weight, double maxSpeed,
                 int flyHeight, int numberOfEngines) {
        super(model, owner, price, produceYear, weight, maxSpeed);
        this.flyHeight = flyHeight;
        this.numberOfEngines = numberOfEngines;
    }

    public int getFlyHeight() {return flyHeight;}
    public void setFlyHeight(int flyHeight) {this.flyHeight = flyHeight;}

    public int getNumberOfEngines() {return numberOfEngines;}
    public void setNumberOfEngines(int numberOfEngines) {this.numberOfEngines = numberOfEngines;}

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + super.getModel() + '\'' +
                ", owner='" + super.getOwner() + '\'' +
                ", price=" + super.getPrice() +
                ", produceYear=" + super.getProduceYear() +
                ", weight=" + super.getWeight() +
                ", maxSpeed=" + super.getMaxSpeed() +
                "flyHeight=" + flyHeight +
                ", numberOfEngines=" + numberOfEngines +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Plane plane = (Plane) o;
        return getFlyHeight() == plane.getFlyHeight() && getNumberOfEngines() == plane.getNumberOfEngines();
    }

}
