package taskForClass;

import java.util.Objects;

class PassengerPlane extends Plane {

    private double avgPriceForTicket;

    public PassengerPlane(String model, String owner, int price, int produceYear, double weight,
                          double maxSpeed, int flyHeight, int numberOfEngines, double avgPriceForTicket) {
        super(model, owner, price, produceYear, weight, maxSpeed, flyHeight, numberOfEngines);
        this.avgPriceForTicket = avgPriceForTicket;
    }

    public double getAvgPriceForTicket() {return avgPriceForTicket;}
    public void setAvgPriceForTicket(double avgPriceForTicket) {this.avgPriceForTicket = avgPriceForTicket;}

    @Override
    public String toString() {
        return "PassengerPlane{" +
                "model='" + super.getModel() + '\'' +
                ", owner='" + super.getOwner() + '\'' +
                ", price=" + super.getPrice() +
                ", produceYear=" + super.getProduceYear() +
                ", weight=" + super.getWeight() +
                ", maxSpeed=" + super.getMaxSpeed() +
                "flyHeight=" + super.getFlyHeight() +
                ", numberOfEngines=" + super.getNumberOfEngines() +
                "avgPriceForTicket=" + avgPriceForTicket +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        PassengerPlane that = (PassengerPlane) o;
        return that.getAvgPriceForTicket() == getAvgPriceForTicket();
    }

}
