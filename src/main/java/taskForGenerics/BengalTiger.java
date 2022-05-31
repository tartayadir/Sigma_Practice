package taskForGenerics;

public class BengalTiger extends Tiger{

    public BengalTiger(int age, int weight, String placeOfLiving) {
        super(age, weight, placeOfLiving);
    }

    public String toString() {
        return "BengalTiger{" +
                "age=" + this.getAge() +
                ", weight=" + this.getWeight() +
                ", placeOfLiving='" + this.getPlaceOfLiving() + '\'' +
                '}';
    }
}
