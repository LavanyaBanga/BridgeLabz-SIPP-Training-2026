import java.util.Scanner;

public class Warehouse{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int[] stock = {10, 20, 30, 40, 20, 50};

        int max = stock[0];
        int min = stock[0];
        int total = 0;


        for (int i = 0; i < stock.length; i++) {
            if (stock[i] > max)
                max = stock[i];

            if (stock[i] < min)
                min = stock[i];

            total += stock[i];
        }

        System.out.println("Maximum Stock = " + max);
        System.out.println("Minimum Stock = " + min);
        System.out.println("Total Stock = " + total);

        // Detect Duplicates
        System.out.println("\nDuplicate Quantities:");

        boolean found = false;

        for (int i = 0; i < stock.length; i++) {
            for (int j = i + 1; j < stock.length; j++) {
                if (stock[i] == stock[j]) {
                    System.out.println(stock[i]);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No Duplicates Found");
        }

        // Rotate Array
        System.out.print("\nEnter k positions to rotate: ");
        int k = sc.nextInt();

        k = k % stock.length;

        int[] rotated = new int[stock.length];

        for (int i = 0; i < stock.length; i++) {
            rotated[(i + k) % stock.length] = stock[i];
        }

        System.out.println("\nRotated Array:");

        for (int num : rotated) {
            System.out.print(num + " ");
        }

        // 2D Shelf Grid
        int[][] shelf = {
                {1, 2, 3},
                {4, 5, 6}
        };

        System.out.println("\n\nOriginal Shelf Grid:");

        for (int i = 0; i < shelf.length; i++) {
            for (int j = 0; j < shelf[0].length; j++) {
                System.out.print(shelf[i][j] + " ");
            }
            System.out.println();
        }


        System.out.println("\nTransposed Shelf Grid:");

        for (int j = 0; j < shelf[0].length; j++) {
            for (int i = 0; i < shelf.length; i++) {
                System.out.print(shelf[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}