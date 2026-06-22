import java.io.*;

public class Grocery {
    public static void main(String[] args) {
        int lineCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("bill.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                lineCount++;
            }

            System.out.println("Total lines = " + lineCount);

        } catch (IOException e) {
            System.out.println("Error reading bill file");
        }
    }
}