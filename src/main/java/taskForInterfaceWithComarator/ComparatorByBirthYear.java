package taskForInterfaceWithComarator;

import java.util.Comparator;

public class ComparatorByBirthYear implements Comparator {

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
