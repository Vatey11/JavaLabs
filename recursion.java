import java.lang.reflect.Array;
import java.util.Arrays;

public class recursion {
    public static void main(String[] args) {

        int[] array = {5, 2, 8, 4, 1, 9, 6, 3, 7};

        System.out.println("original array: "+ Arrays.toString(array));
        // recursion way
        recursionFunction(array);

        // iteration way
        MergeSort.mergeSort(array);
        
        System.out.println("after merge sort: " + Arrays.toString(array));

    }

    // recursion way 
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

// iteration way
class MergeSort {

    public static void mergeSort(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n]; // Temporary array for merging

        for (int size = 1; size < n; size *= 2) {
            for (int left = 0; left < n - size; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);
                merge(arr, temp, left, mid, right);
            }
        }
    }

    public static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left; // Index for left subarray
        int j = mid + 1; // Index for right subarray
        int k = left; // Index for temporary array

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements from the left subarray, if any
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        // Copy the remaining elements from the right subarray, if any
        while (j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        // Copy the merged elements back to the original array
        for (int x = left; x <= right; x++) {
            arr[x] = temp[x];
        }
    }
}