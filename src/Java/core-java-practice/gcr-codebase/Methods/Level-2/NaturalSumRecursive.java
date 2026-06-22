import java.util.Scanner;

public class NaturalSumRecursive {

    public static int sumUsingRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumUsingRecursion(n - 1);
    }

    public static int sumUsingFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter natural number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Not a natural number");
            return;
        }

        int recursionSum = sumUsingRecursion(n);
        int formulaSum = sumUsingFormula(n);

        System.out.println("Sum using recursion = " + recursionSum);
        System.out.println("Sum using formula = " + formulaSum);

        if (recursionSum == formulaSum) {
            System.out.println("Both computations are correct");
        } else {
            System.out.println("Both computations are not correct");
        }
    }
}