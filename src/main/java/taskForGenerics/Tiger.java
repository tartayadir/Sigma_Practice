package taskForGenerics;

public class Tiger extends Animal {

    public Tiger(int age, int weight, String placeOfLiving) {
        super(age, weight, placeOfLiving);
    }

    public String toString() {
        return "Tiger{" +
                "age=" + this.getAge() +
                ", weight=" + this.getWeight() +
                ", placeOfLiving='" + this.getPlaceOfLiving() + '\'' +
                '}';
    }
}
