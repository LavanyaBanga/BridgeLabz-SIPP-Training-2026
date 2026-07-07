import java.util.*;

public class SportsMeet {

    static void bubbleSort(int[] scores) {
        int n = scores.length;
        int totalSwaps = 0;
        boolean alreadySorted = true;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (scores[j] > scores[j + 1]) {
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;
                    swapped = true;
                    alreadySorted = false;
                    totalSwaps++;
                }
            }

            if (!swapped) break;
        }

        System.out.println("Sorted Scores: " + Arrays.toString(scores));
        System.out.println("Total Swaps: " + totalSwaps);
        System.out.println("Already Sorted: " + alreadySorted);

        System.out.println("Top 3 Medalists:");
        for (int i = scores.length - 1; i >= scores.length - 3; i--) {
            System.out.println(scores[i]);
        }
    }

    public static void main(String[] args) {
        int[] scores = {64, 25, 12, 22, 11};
        bubbleSort(scores);
    }
}
