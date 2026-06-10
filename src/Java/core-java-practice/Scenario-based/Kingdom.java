import java.util.Scanner;

public class Kingdom{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] incomes = new double[10];
        double totalTaxCollected = 0;

        for (int i = 0; i < 10; i++) {

            System.out.print("Enter income of citizen " + (i + 1) + ": ");
            incomes[i] = sc.nextDouble();

            double tax;

            if (incomes[i] < 10000) {
                tax = incomes[i] * 0.05;
                System.out.println("Tax Bracket: 5%");
            }
            else if (incomes[i] <= 50000) {
                tax = incomes[i] * 0.15;
                System.out.println("Tax Bracket: 15%");
            }
            else {
                tax = incomes[i] * 0.30;
                System.out.println("Tax Bracket: 30%");
            }

            System.out.println("Tax Amount: ₹" + tax);
            System.out.println();

            totalTaxCollected += tax;
        }

        System.out.println("================================");
        System.out.println("Total Tax Collected = ₹" + totalTaxCollected);
        System.out.println("================================");

        sc.close();
    }
}