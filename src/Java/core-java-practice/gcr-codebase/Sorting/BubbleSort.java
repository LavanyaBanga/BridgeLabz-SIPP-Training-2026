import java.util.*;

public class BubbleSortExample {

    static int bubbleSort(int[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        return swaps;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};

        int swaps = bubbleSort(nums);

        System.out.println(Arrays.toString(nums));
        System.out.println("Swaps: " + swaps);
    }
}
