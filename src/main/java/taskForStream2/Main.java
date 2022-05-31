package taskForStream2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr1 = {1, 56, 67, 90, 11, -45, 22, 0, 23, 22, 1, 54};
        int[] arr2 = {1, 34, 52, -21, 21, 22, 59, 27, 9, 80, 54};

        int[] contactedArray = Controller.concatArrays(arr1, arr2);
        Controller.averageValueAndAmountOfElementMoreThenValue(contactedArray);
        contactedArray = Controller.removeReapingMinMax(contactedArray);

        System.out.println("Array after removing copy of min and max :\n" + Arrays.toString(contactedArray));
    }
}
