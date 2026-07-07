import java.util.Scanner;

public class BubbleSortSwapCount {

    public static int bubbleSort(int[] nums) {

        int n = nums.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (nums[j] > nums[j + 1]) {

                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }

        return swaps;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int count = bubbleSort(nums);

        System.out.println("Sorted Array:");

        for (int x : nums) {
            System.out.print(x + " ");
        }

        System.out.println();
        System.out.println("Total Swaps = " + count);
    }
}
