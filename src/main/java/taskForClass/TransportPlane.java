package taskForClass;

import java.util.Objects;

class TransportPlane extends Plane {

   private String typeOfLoad;

    public TransportPlane(String model, String owner, int price, int produceYear, double weight, double maxSpeed,
                          int flyHeight, int numberOfEngines, String typeOfLoad) {
        super(model, owner, price, produceYear, weight, maxSpeed, flyHeight, numberOfEngines);
        this.typeOfLoad = typeOfLoad;
    }

    public String getTypeOfLoad() {return typeOfLoad;}

    public void setTypeOfLoad(String typeOfLoad) {this.typeOfLoad = typeOfLoad;}

    @Override
    public String toString() {
        return "TransportPlane{" +
                "model='" + super.getModel() + '\'' +
                ", owner='" + super.getOwner() + '\'' +
                ", price=" + super.getPrice() +
                ", produceYear=" + super.getProduceYear() +
                ", weight=" + super.getWeight() +
                ", maxSpeed=" + super.getMaxSpeed() +
                "flyHeight=" + super.getFlyHeight() +
                ", numberOfEngines=" + super.getNumberOfEngines() +
                "typeOfLoad='" + typeOfLoad + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        TransportPlane that = (TransportPlane) o;
        return getTypeOfLoad().equals(that.getTypeOfLoad());
    }
}
