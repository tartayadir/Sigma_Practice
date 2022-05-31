package taskForClass;

import java.util.Objects;

class Truck extends Car {

   private String typeOfTruck;

    public Truck(String model, String owner, int price, int produceYear) {

        super(model, owner, price, produceYear);
        this.typeOfTruck = "typeOfTruck";
    }

    public String getTypeOfTruck() {return typeOfTruck;}
    public void setTypeOfTruck(String typeOfTruck) {this.typeOfTruck = typeOfTruck;}

    @Override
    public String toString() {
        return "Truck{" +
                "model='" + super.getModel() + '\'' +
                ", owner='" + super.getOwner() + '\'' +
                ", price=" + super.getPrice() +
                ", produceYear=" + super.getProduceYear() +
                ", weight=" + super.getWeight() +
                ", maxSpeed=" + super.getMaxSpeed() +
                "isElectric=" + super.isElectric() +
                ", typeOfTransmission='" + super.getTypeOfTransmission() + '\'' +
                "typeOfTruck='" + typeOfTruck + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Truck truck = (Truck) o;
        return getTypeOfTruck().equals(truck.getTypeOfTruck());
    }
}
