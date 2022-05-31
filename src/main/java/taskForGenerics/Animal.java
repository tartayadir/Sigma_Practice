package taskForGenerics;

public class Animal {

    private int age, weight;
    private String placeOfLiving;

    public Animal(int age, int weight, String placeOfLiving) {
        this.age = age;
        this.weight = weight;
        this.placeOfLiving = placeOfLiving;
    }

    public int getAge() {return age;}
    public int getWeight() {return weight;}
    public String getPlaceOfLiving() {return placeOfLiving;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        //if(o.getClass() != this.getClass()) return false;
        Animal animal = (Animal) o;
        return this.age == animal.getAge() && this.weight == animal.getWeight() && this.placeOfLiving.equals(animal.getPlaceOfLiving());
    }

    @Override
    public int hashCode() {
       return age*17 + weight*31 + placeOfLiving.hashCode()*11;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                ", weight=" + weight +
                ", placeOfLiving='" + placeOfLiving + '\'' +
                '}';
    }
}
