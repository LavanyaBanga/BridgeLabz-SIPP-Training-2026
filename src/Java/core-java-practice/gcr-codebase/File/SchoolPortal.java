import java.io.*;
import java.util.*;

public class SchoolPortal {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new FileReader("students.txt"));
                FileWriter fw = new FileWriter("report.txt", true)
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String name = data[0];
                int marks1 = Integer.parseInt(data[1]);
                int marks2 = Integer.parseInt(data[2]);
                int marks3 = Integer.parseInt(data[3]);

                double average = (marks1 + marks2 + marks3) / 3.0;

                fw.write("Name: " + name + ", Average: " + average + "\n");
            }

            System.out.println("Report generated successfully");

        } catch (FileNotFoundException e) {
            System.out.println("Student file not found");

        } catch (IOException e) {
            System.out.println("Error reading or writing file");
        }
    }
}