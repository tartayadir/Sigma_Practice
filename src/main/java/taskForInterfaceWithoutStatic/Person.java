package taskForInterfaceWithoutStatic;

public class Person {

    private String name, region;
    private int birthYear;
    private boolean isMale;

    public Person(String name, String region, int birthYear, boolean isMale) {
        this.name = name;
        this.region = region;
        this.birthYear = birthYear;
        this.isMale = isMale;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getRegion() {return region;}
    public void setRegion(String region) {this.region = region;}

    public int getBirthYear() {return birthYear;}
    public void setBirthYear(int birthYear) {this.birthYear = birthYear;}

    public boolean isMale() {return isMale;}
    public void setMale(boolean male) {isMale = male;}

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", birthYear=" + birthYear +
                ", isMale=" + isMale +
                '}';
    }
}

