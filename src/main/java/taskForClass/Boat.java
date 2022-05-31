package taskForClass;

import java.util.Objects;

class Boat extends Vehicle {

    private String typeOfEngine;
    private int numberOfDecks;

    public Boat(String model, String owner, int price, int produceYear,
                double weight, double maxSpeed, String typeOfEngine, int numberOfDecks) {
        super(model, owner, price, produceYear, weight, maxSpeed);
        this.typeOfEngine = typeOfEngine;
        this.numberOfDecks = numberOfDecks;
    }

    public String getTypeOfEngine() {return typeOfEngine;}
    public void setTypeOfEngine(String typeOfEngine) {this.typeOfEngine = typeOfEngine;}

    public int getNumberOfDecks() {return numberOfDecks;}
    public void setNumberOfDecks(int numberOfDecks) {this.numberOfDecks = numberOfDecks;}

    @Override
    public String toString() {
        return "Boat{" +
                "model='" + super.getModel() + '\'' +
                ", owner='" + super.getOwner() + '\'' +
                ", price=" + super.getPrice() +
                ", produceYear=" + super.getProduceYear() +
                ", weight=" + super.getWeight() +
                ", maxSpeed=" + super.getMaxSpeed() +
                "typeOfEngine='" + typeOfEngine + '\'' +
                ", numberOfDecks=" + numberOfDecks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Boat boat = (Boat) o;
        return getNumberOfDecks() == boat.getNumberOfDecks() && getTypeOfEngine().equals(boat.getTypeOfEngine());
    }


}