import java.io.*;
import java.util.*;

public class StudentGradeManager {

    static String[] names = new String[100];
    static int[][] marks = new int[100][5];
    static int[] total = new int[100];
    static double[] percentage = new double[100];
    static char[] grade = new char[100];
    static int count = 0;

    public static void main(String[] args) {
        try {
            readFromFile("students.txt");
            calculateGrades();

            System.out.println("Before Sorting:");
            display();

            sortByTotalMarks();

            System.out.println("\nAfter Sorting:");
            display();

            searchByName("Lavanya");

            writeReport("report.txt");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void readFromFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            names[count] = data[0];

            for (int i = 0; i < 5; i++) {
                marks[count][i] = Integer.parseInt(data[i + 1]);
            }

            count++;
        }

        br.close();
    }

    static void calculateGrades() {
        for (int i = 0; i < count; i++) {
            int sum = 0;

            for (int j = 0; j < 5; j++) {
                sum += marks[i][j];
            }

            total[i] = sum;
            percentage[i] = sum / 5.0;

            if (percentage[i] >= 90) {
                grade[i] = 'A';
            } else {
                if (percentage[i] >= 75) {
                    grade[i] = 'B';
                } else {
                    if (percentage[i] >= 60) {
                        grade[i] = 'C';
                    } else {
                        if (percentage[i] >= 40) {
                            grade[i] = 'D';
                        } else {
                            grade[i] = 'F';
                        }
                    }
                }
            }
        }
    }

    static void searchByName(String searchName) {
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(searchName)) {
                System.out.println("\nStudent Found:");
                System.out.println(names[i] + " Total: " + total[i] + " Grade: " + grade[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nStudent not found.");
        }
    }

    static void sortByTotalMarks() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (total[j] < total[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }

    static void swap(int a, int b) {
        String tempName = names[a];
        names[a] = names[b];
        names[b] = tempName;

        int tempTotal = total[a];
        total[a] = total[b];
        total[b] = tempTotal;

        double tempPercent = percentage[a];
        percentage[a] = percentage[b];
        percentage[b] = tempPercent;

        char tempGrade = grade[a];
        grade[a] = grade[b];
        grade[b] = tempGrade;

        int[] tempMarks = marks[a];
        marks[a] = marks[b];
        marks[b] = tempMarks;
    }

    static void display() {
        for (int i = 0; i < count; i++) {
            System.out.println(names[i] + " | Total: " + total[i] + " | %: " + percentage[i] + " | Grade: " + grade[i]);
        }
    }

    static void writeReport(String fileName) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

        bw.write("Student Grade Report\n");
        bw.write("----------------------\n");

        for (int i = 0; i < count; i++) {
            bw.write(names[i] + " | Total: " + total[i] + " | Percentage: " + percentage[i] + " | Grade: " + grade[i]);
            bw.newLine();
        }

        bw.close();

        System.out.println("\nReport written successfully.");
    }
}
