import java.util.*;

public class Main {

    static int bubbleSort(int[] arr) {
        int swaps = 0;
        boolean alreadySorted = true;

        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {   // descending for top scores
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    swapped = true;
                    alreadySorted = false;
                }
            }

            if (!swapped) {
                break;
            }
        }

        if (alreadySorted) {
            System.out.println("Bubble Sort: Already sorted best case.");
        }

        return swaps;
    }

    static int insertionSort(int[] arr) {
        int shifts = 0;
        boolean alreadySorted = true;

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            if (arr[j] < key) {
                alreadySorted = false;
            }

            while (j >= 0 && arr[j] < key) {  // descending
                arr[j + 1] = arr[j];
                shifts++;
                j--;
            }

            arr[j + 1] = key;
        }

        if (alreadySorted) {
            System.out.println("Insertion Sort: Already sorted best case.");
        }

        return shifts;
    }

    static void printTop3(int[] scores) {
        System.out.println("Gold Medalist Score: " + scores[0]);
        System.out.println("Silver Medalist Score: " + scores[1]);
        System.out.println("Bronze Medalist Score: " + scores[2]);
    }

    public static void main(String[] args) {
        int[] scores = {
                78, 90, 56, 88, 92, 67, 45, 99, 81, 73,
                60, 85, 91, 77, 69, 95, 82, 74, 89, 58,
                66, 93, 71, 84, 79, 97, 55, 62, 87, 80,
                94, 76, 68, 72, 83, 98, 59, 61, 70, 75,
                86, 96, 64, 63, 57, 52, 53, 54, 51, 50
        };

        int[] bubbleScores = scores.clone();
        int[] insertionScores = scores.clone();

        int bubbleSwaps = bubbleSort(bubbleScores);

        System.out.println("After Bubble Sort:");
        System.out.println(Arrays.toString(bubbleScores));
        System.out.println("Total Bubble Sort Swaps: " + bubbleSwaps);
        printTop3(bubbleScores);

        System.out.println();

        int insertionShifts = insertionSort(insertionScores);

        System.out.println("After Insertion Sort:");
        System.out.println(Arrays.toString(insertionScores));
        System.out.println("Total Insertion Sort Shifts: " + insertionShifts);
        printTop3(insertionScores);

        System.out.println("\nTrace for array [64, 25, 12, 22, 11]:");

        int[] trace = {64, 25, 12, 22, 11};

        for (int i = 0; i < trace.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < trace.length - i - 1; j++) {
                if (trace[j] > trace[j + 1]) {
                    int temp = trace[j];
                    trace[j] = trace[j + 1];
                    trace[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(trace));

            if (!swapped) {
                break;
            }
        }
    }
}
