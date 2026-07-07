import java.util.Scanner;

public class MovieRatingsSelectionSort {

    public static void selectionSort(int[] ratings) {
        int n = ratings.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (ratings[j] < ratings[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = ratings[i];
            ratings[i] = ratings[minIndex];
            ratings[minIndex] = temp;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] ratings = new int[n];

        for (int i = 0; i < n; i++) {
            ratings[i] = sc.nextInt();
        }

        selectionSort(ratings);

        for (int x : ratings) {
            System.out.print(x + " ");
        }
    }
}
