package taskForClass;

import java.util.Objects;

class Tanker extends Boat {

    private String typeOfLoad;

    public Tanker(String model, String owner, int price, int produceYear, double weight, double maxSpeed,
                  String typeOfEngine, int numberOfDecks, String typeOfLoad) {
        super(model, owner, price, produceYear, weight, maxSpeed, typeOfEngine, numberOfDecks);
        this.typeOfLoad = typeOfLoad;
    }

    public String getTypeOfLoad() {return typeOfLoad;}
    public void setTypeOfLoad(String typeOfLoad) {this.typeOfLoad = typeOfLoad;}

    @Override
    public String toString() {
        return "Tanker{" +
                "model='" + super.getModel() + '\'' +
                ", owner='" + super.getOwner() + '\'' +
                ", price=" + super.getPrice() +
                ", produceYear=" + super.getProduceYear() +
                ", weight=" + super.getWeight() +
                ", maxSpeed=" + super.getMaxSpeed() +
                "typeOfEngine='" + super.getTypeOfEngine() + '\'' +
                ", numberOfDecks=" + super.getNumberOfDecks() +
                "typeOfLoad='" + typeOfLoad + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Tanker tanker = (Tanker) o;
        return getTypeOfLoad().equals( tanker.getTypeOfLoad());
    }

}
