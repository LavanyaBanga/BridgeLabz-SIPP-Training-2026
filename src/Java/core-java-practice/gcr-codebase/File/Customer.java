import java.io.*;

public class Customer{
    public static void main(String[] args) {
        int count = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            for (int i = 1; i <= 5; i++) {
                System.out.print("Enter feedback " + i + ": ");
                String feedback = br.readLine();

                if (feedback.toLowerCase().contains("good")) {
                    count++;
                }
            }

            System.out.println("Good Feedback Count = " + count);

        } catch (IOException e) {
            System.out.println("Error reading feedback");
        }
    }
}