import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DailyExpense{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (FileWriter fw = new FileWriter("expenses.txt", true)) {

            System.out.print("Enter category: ");
            String category = sc.nextLine();

            System.out.print("Enter amount: ");
            int amount = sc.nextInt();

            fw.write(category + " - " + amount + "\n");

            System.out.println("Expense saved successfully");

        } catch (IOException e) {
            System.out.println("Error writing expense");
        }
    }
}