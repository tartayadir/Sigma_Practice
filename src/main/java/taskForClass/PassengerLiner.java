package taskForClass;

import java.util.Objects;

class PassengerLiner extends Boat {

    private int numberOfPassengerCabins;

    public PassengerLiner(String model, String owner, int price, int produceYear, double weight, double maxSpeed,
                          String typeOfEngine, int numberOfDecks, int numberOfPassengerCabins) {

        super(model, owner, price, produceYear, weight, maxSpeed, typeOfEngine, numberOfDecks);
        this.numberOfPassengerCabins = numberOfPassengerCabins;
    }

    public int getNumberOfPassengerCabins() {return numberOfPassengerCabins;}
    public void setNumberOfPassengerCabins(int numberOfPassengerCabins) {this.numberOfPassengerCabins = numberOfPassengerCabins;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        PassengerLiner that = (PassengerLiner) o;
        return getNumberOfPassengerCabins() == that.getNumberOfPassengerCabins();
    }

    @Override
    public String toString() {
        return "PassengerLiner{" +
                "model='" + super.getModel() + '\'' +
                ", owner='" + super.getOwner() + '\'' +
                ", price=" + super.getPrice() +
                ", produceYear=" + super.getProduceYear() +
                ", weight=" + super.getWeight() +
                ", maxSpeed=" + super.getMaxSpeed() +
                "typeOfEngine='" + super.getTypeOfEngine() + '\'' +
                ", numberOfDecks=" + super.getNumberOfDecks() +
                "numberOfPassengerCabins=" + numberOfPassengerCabins +
                '}';
    }
}
