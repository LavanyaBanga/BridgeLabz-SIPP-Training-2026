import java.io.*;

public class Result {

    public static void main(String[] args) {

        String inputFile = "students.txt";
        String outputFile = "reportcard.txt";

        try {

            BufferedReader br = new BufferedReader(new FileReader(inputFile));

        
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(outputFile, true));

            bw.write("----- Student Report Card -----");
            bw.newLine();

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(" ");

                String name = data[0];

                int total = 0;

                for (int i = 1; i < data.length; i++) {
                    total += Integer.parseInt(data[i]);
                }

                double average = (double) total / (data.length - 1);

                bw.write("Name: " + name);
                bw.newLine();

                bw.write("Total Marks: " + total);
                bw.newLine();

                bw.write("Average Marks: " + average);
                bw.newLine();

                bw.write("--------------------------");
                bw.newLine();
            }

            br.close();
            bw.close();

            System.out.println("Report card generated successfully.");

        }
        catch (FileNotFoundException e) {
            System.out.println("Error: students.txt file not found.");
        }
        catch (NumberFormatException e) {
            System.out.println("Error: Invalid marks format.");
        }
        catch (IOException e) {
            System.out.println("Error while reading/writing file.");
        }
    }
}
