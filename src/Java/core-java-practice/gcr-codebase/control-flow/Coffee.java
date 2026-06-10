import java.util.Scanner;

public class Coffee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double gstRate = 0.18; // 18% GST

        while (true) {
            System.out.print("Enter coffee type (Espresso/Cappuccino/Latte) or 'exit': ");
            String coffeeType = sc.nextLine();

            if (coffeeType.equalsIgnoreCase("exit")) {
                System.out.println("Cafe Closed!");
                break;
            }

            double price = 0;

            switch (coffeeType.toLowerCase()) {
                case "espresso":
                    price = 120;
                    break;

                case "cappuccino":
                    price = 150;
                    break;

                case "latte":
                    price = 180;
                    break;

                default:
                    System.out.println("Invalid Coffee Type!");
                    continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            double totalBill = price * quantity;
            double gst = totalBill * gstRate;
            double finalBill = totalBill + gst;

            System.out.println("Bill Amount = ₹" + totalBill);
            System.out.println("GST = ₹" + gst);
            System.out.println("Final Bill = ₹" + finalBill);
            System.out.println();
        }

        sc.close();
    }
}