package taskForClass;

import java.util.Objects;

class FighterPlane extends Plane {

    private String typeOfPlane;
    private String typeOfWeapon;

    public FighterPlane(String model, String owner, int price, int produceYear, double weight, double maxSpeed, int flyHeight,
                        int numberOfEngines, String typeOfPlane, String typeOfWeapon) {
        super(model, owner, price, produceYear, weight, maxSpeed, flyHeight, numberOfEngines);
        this.typeOfPlane = typeOfPlane;
        this.typeOfWeapon = typeOfWeapon;
    }

    void setTypeOfPlane(String typeOfPlane){this.typeOfPlane = typeOfPlane;}
    void setTypeOfWeapon(String typeOfWeapon){this.typeOfWeapon = typeOfWeapon;}

    protected String getTypeOfPlane(){return typeOfPlane;}
    protected String getTypeOfWeapon(){return typeOfWeapon;}

    @Override
    public String toString() {
        return "FighterPlane{" +
                "model='" + super.getModel() + '\'' +
                ", owner='" + super.getOwner() + '\'' +
                ", price=" + super.getPrice() +
                ", produceYear=" + super.getProduceYear() +
                ", weight=" + super.getWeight() +
                ", maxSpeed=" + super.getMaxSpeed() +
                "flyHeight=" + super.getFlyHeight() +
                ", numberOfEngines=" + super.getNumberOfEngines() +
                "typeOfPlane='" + typeOfPlane + '\'' +
                ", typeOfWeapon='" + typeOfWeapon + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FighterPlane)) return false;
        if (!super.equals(o)) return false;
        FighterPlane that = (FighterPlane) o;
        return getTypeOfPlane().equals(that.getTypeOfPlane()) && getTypeOfWeapon().equals(that.getTypeOfWeapon());
    }

}
