package taskForClass;

import java.util.Objects;

class Bus extends Car {

    private boolean hasPlaceForWheelchair;
    private int numberOfFloors;
    private double ticketPrice;

    public Bus(String model, String owner, int price, int produceYear, double weight, double maxSpeed, boolean isElectric,
               String typeOfTransmission, boolean hasPlaceForWheelchair, int numberOfFloors, double ticketPrice) {

        super(model, owner, price, produceYear, weight, maxSpeed, isElectric, typeOfTransmission);
        this.hasPlaceForWheelchair = hasPlaceForWheelchair;
        this.numberOfFloors = numberOfFloors;
        this.ticketPrice = ticketPrice;
    }

    public Bus(String model, String owner, int price, int produceYear) {

        super(model, owner, price, produceYear);
        this.hasPlaceForWheelchair = true;
        this.numberOfFloors = 4;
        this.ticketPrice = 8;
    }

    public boolean isHasPlaceForWheelchair() {return hasPlaceForWheelchair;}
    public void setHasPlaceForWheelchair(boolean hasPlaceForWheelchair) {this.hasPlaceForWheelchair = hasPlaceForWheelchair;}

    public int getNumberOfFloors() {return numberOfFloors;}
    public void setNumberOfFloors(int numberOfFloors) {this.numberOfFloors = numberOfFloors;}

    public double getTicketPrice() {return ticketPrice;}
    public void setTicketPrice(double ticketPrice) {this.ticketPrice = ticketPrice;}

    @Override
    public String toString() {
        return "Bus{" +
                "model='" + super.getModel() + '\'' +
                ", owner='" + super.getOwner() + '\'' +
                ", price=" + super.getPrice() +
                ", produceYear=" + super.getProduceYear() +
                ", weight=" + super.getWeight() +
                ", maxSpeed=" + super.getMaxSpeed() +
                "isElectric=" + super.isElectric() +
                ", typeOfTransmission='" + super.getTypeOfTransmission() + '\'' +
                "hasPlaceForWheelchair=" + hasPlaceForWheelchair +
                ", numberOfFloors=" + numberOfFloors +
                ", ticketPrice=" + ticketPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Bus bus = (Bus) o;
        return isHasPlaceForWheelchair() == bus.isHasPlaceForWheelchair() && getNumberOfFloors() == bus.getNumberOfFloors() && bus.getTicketPrice() == getTicketPrice();
    }
}
