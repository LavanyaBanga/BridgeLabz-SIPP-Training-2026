class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBilling {

    public static void processPayment(double billAmount, double paidAmount)
            throws InsufficientFundsException {

        if (paidAmount < billAmount) {
            throw new InsufficientFundsException(
                    "Payment Failed: Insufficient Funds!"
            );
        }

        System.out.println("Payment Successful.");
    }

    public static void main(String[] args) {


        try {
            int totalBill = 5000;
            int items = 0;

            double avgCost = totalBill / items;
            System.out.println(avgCost);

        } catch (ArithmeticException e) {
            System.out.println("Error: Bill cannot have zero items.");
        }


        try {
            String[] patients = {"Aman", "Riya", "Karan"};

            System.out.println(patients[5]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid patient index.");
        }


        try {
            String input = "ABC123";

            int amount = Integer.parseInt(input);
            System.out.println(amount);

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid numeric input.");
        }


        try {
            processPayment(5000, 3000);

        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Hospital Billing System Running Safely...");
    }
}