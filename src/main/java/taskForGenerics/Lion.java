package taskForGenerics;

public class Lion extends Animal{

    public Lion(int age, int weight, String placeOfLiving) {
        super(age, weight, placeOfLiving);
    }

    public String toString() {
        return "Lion{" +
                "age=" + this.getAge() +
                ", weight=" + this.getWeight() +
                ", placeOfLiving='" + this.getPlaceOfLiving() + '\'' +
                '}';
    }
}
