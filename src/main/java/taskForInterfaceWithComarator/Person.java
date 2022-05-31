package taskForInterfaceWithComarator;

import java.util.Comparator;

public class Person {

    public static class ComparatorByBirthYear implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {

            int result = ((Person)o1).getBirthYear() - (((Person)o2).getBirthYear());
            if (result!=0){
                return result;
            }else {
                result = Boolean.compare(((Person)o1).isMale(),(((Person)o2).isMale()));
                if (result!=0){
                    return result;
                }else {
                    result =((Person)o1).getName().compareTo(((Person)o2).getName());
                    if (result!=0){
                        return result;
                    }else {
                        result = ((Person)o1).getRegion().compareTo(((Person)o2).getRegion());
                        return result;
                    }
                }
            }
        }
    }


    public static class ComparatorByMale implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {

            int result = Boolean.compare(((Person)o1).isMale(),(((Person)o2).isMale()));
            if (result!=0){
                return result;
            }else {
                result =((Person)o1).getName().compareTo(((Person)o2).getName());
                if (result!=0){
                    return result;
                }else {
                    result = ((Person)o1).getRegion().compareTo(((Person)o2).getRegion());
                    if (result!=0){
                        return result;
                    }else {
                        result = ((Person)o1).getBirthYear() - (((Person)o2).getBirthYear());
                        return result;
                    }
                }
            }
        }
    }


    public static class ComparatorByRegion implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {

            int result = ((Person)o1).getRegion().compareTo(((Person)o2).getRegion());
            if (result!=0){
                return result;
            }else {
                result =((Person)o1).getName().compareTo(((Person)o2).getName());
                if (result!=0){
                    return result;
                }else {
                    result = Boolean.compare(((Person)o1).isMale(),(((Person)o2).isMale()));
                    if (result!=0){
                        return result;
                    }else {
                        result = ((Person)o1).getBirthYear() - (((Person)o2).getBirthYear());
                        return result;
                    }
                }
            }
        }
    }

    public static class ComparatorByName implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {

            int result =((Person)o1).getName().compareTo(((Person)o2).getName());

            if (result!=0){
                return result;
            }else {
                result = ((Person)o1).getRegion().compareTo(((Person)o2).getRegion());

                if (result!=0){
                    return result;
                }else {
                    result = ((Person)o1).getBirthYear() - (((Person)o2).getBirthYear());

                    if (result!=0){
                        return result;
                    }else {
                        result = Boolean.compare(((Person)o1).isMale(),(((Person)o2).isMale()));
                        return result;
                    }
                }
            }
        }

    }

    private String name, region;
    private int birthYear;
    private boolean isMale;

    public Person(){}

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
