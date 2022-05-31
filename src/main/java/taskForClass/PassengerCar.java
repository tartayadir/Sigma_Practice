package taskForClass;

import java.util.Objects;

class PassengerCar extends Car {

    private int numberOfDoors;
    private String carClass;
    private boolean hasTrailer;

    public PassengerCar(String model, String owner, int price, int produceYear, double weight, double maxSpeed, boolean isElectric,
                        String typeOfTransmission, int numberOfDoors, String carClass, boolean hasTrailer) {
        super(model, owner, price, produceYear, weight, maxSpeed, isElectric, typeOfTransmission);
        this.numberOfDoors = numberOfDoors;
        this.carClass = carClass;
        this.hasTrailer = hasTrailer;
    }

    public PassengerCar(String model, String owner, int price, int produceYear) {
        super(model, owner, price, produceYear);
        this.numberOfDoors = 4;
        this.carClass = "S";
        this.hasTrailer = false;
    }

    public int getNumberOfDoors() {return numberOfDoors;}
    public void setNumberOfDoors(int numberOfDoors) {this.numberOfDoors = numberOfDoors;}

    public String getCarClass() {return carClass;}
    public void setCarClass(String carClass) {this.carClass = carClass;}

    public boolean isHasTrailer() {return hasTrailer;}
    public void setHasTrailer(boolean hasTrailer) {this.hasTrailer = hasTrailer;}

    @Override
    public String toString() {
        return "PassengerCar{" +
                "model='" + super.getModel() + '\'' +
                ", owner='" + super.getOwner() + '\'' +
                ", price=" + super.getPrice() +
                ", produceYear=" + super.getProduceYear() +
                ", weight=" + super.getWeight() +
                ", maxSpeed=" + super.getMaxSpeed() +
                "isElectric=" + super.isElectric() +
                ", typeOfTransmission='" + super.getTypeOfTransmission() + '\'' +
                "numberOfDoors=" + numberOfDoors +
                ", carClass='" + carClass + '\'' +
                ", hasTrailer=" + hasTrailer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        PassengerCar that = (PassengerCar) o;
        return getNumberOfDoors() == that.getNumberOfDoors() && isHasTrailer() == that.isHasTrailer() && getCarClass().equals(that.getCarClass());
    }
}
