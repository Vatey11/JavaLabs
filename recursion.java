import java.lang.reflect.Array;
import java.util.Arrays;

public class recursion {
    public static void main(String[] args) {

        int[] array = {5, 2, 8, 4, 1, 9, 6, 3, 7};

        System.out.println("original array: "+ Arrays.toString(array));
        recursionFunction(array);
        System.out.println("after merge sort: " + Arrays.toString(array));

    }

    public static void recursionFunction(int[] array) {

        // base case when array already sorted
        if (array.length < 2) {
            return;
        }

        // when array not sort

        // divide n into 2 part: left array and right array
        int mid = array.length/2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length - mid];

        // for left array
        for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
        }
        // for right array
        for (int i = mid; i < array.length; i++) {
            rightArray[i-mid] = array[i];
        }

        // recursive sort left and right
        recursionFunction(leftArray);
        recursionFunction(rightArray);

        // merge the sort array of left and right
        merge(leftArray, rightArray, array);
    }

    public static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftLength = leftArray.length;
        int rightLength = rightArray.length;
        int i = 0;
        int k = 0;
        int j = 0;

        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            }
            else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

}
