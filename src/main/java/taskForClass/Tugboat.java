package taskForClass;

import java.util.Objects;

class Tugboat extends Boat {

    private String typeOfTugboat;

    public Tugboat(String model, String owner, int price, int produceYear, double weight,
                   double maxSpeed, String typeOfEngine, int numberOfDecks, String typeOfTugboat) {
        super(model, owner, price, produceYear, weight, maxSpeed, typeOfEngine, numberOfDecks);
        this.typeOfTugboat = typeOfTugboat;
    }

    public String getTypeOfTugboat() {return typeOfTugboat;}
    public void setTypeOfTugboat(String typeOfTugboat) {this.typeOfTugboat = typeOfTugboat;}

    @Override
    public String toString() {
        return "Tugboat{" +
                "model='" + super.getModel() + '\'' +
                ", owner='" + super.getOwner() + '\'' +
                ", price=" + super.getPrice() +
                ", produceYear=" + super.getProduceYear() +
                ", weight=" + super.getWeight() +
                ", maxSpeed=" + super.getMaxSpeed() +
                "typeOfEngine='" + super.getTypeOfEngine() + '\'' +
                ", numberOfDecks=" + super.getNumberOfDecks() +
                "typeOfTugboat='" + typeOfTugboat + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Tugboat tugboat = (Tugboat) o;
        return getTypeOfTugboat().equals(tugboat.getTypeOfTugboat());
    }

}
