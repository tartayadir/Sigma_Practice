package taskForClass;

import java.util.Objects;

class Vehicle {

    private String model;
    private String owner;
    private int price;
    private int produceYear;
    private double weight;
    private double maxSpeed;

    public Vehicle(String model, String owner, int price, int produceYear, double weight, double maxSpeed) {
        this.model = model;
        this.owner = owner;
        this.price = price;
        this.produceYear = produceYear;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
    }

    public Vehicle(String model, String owner, int price, int produceYear) {
        this.model = model;
        this.owner = owner;
        this.price = price;
        this.produceYear = produceYear;
        this.weight = 500;
        this.maxSpeed = 210;
    }

    public String getModel() {return model;}
    public void setModel(String model) {this.model = model;}

    public String getOwner() {return owner;}
    public void setOwner(String owner) {this.owner = owner;}

    public int getPrice() {return price;}
    public void setPrice(int price) {this.price = price;}

    public int getProduceYear() {return produceYear;}
    public void setProduceYear(int produceYear) {this.produceYear = produceYear;}

    public double getWeight() {return weight;}
    public void setWeight(double weight) {this.weight = weight;}

    public double getMaxSpeed() {return maxSpeed;}
    public void setMaxSpeed(double maxSpeed) {this.maxSpeed = maxSpeed;}

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", owner='" + owner + '\'' +
                ", price=" + price +
                ", produceYear=" + produceYear +
                ", weight=" + weight +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Vehicle vehicle = (Vehicle) o;
        return getPrice() == vehicle.getPrice() && getProduceYear() == vehicle.getProduceYear() && vehicle.getWeight() == getWeight() && vehicle.getMaxSpeed() == getMaxSpeed() && getModel().equals(vehicle.getModel()) && getOwner().equals(vehicle.getOwner());
    }

}
