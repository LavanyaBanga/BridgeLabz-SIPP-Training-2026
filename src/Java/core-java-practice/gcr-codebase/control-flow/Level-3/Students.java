import java.util.Scanner;

public class Students {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Physics Marks: ");
        double physics = sc.nextDouble();

        System.out.print("Chemistry Marks: ");
        double chemistry = sc.nextDouble();

        System.out.print("Maths Marks: ");
        double maths = sc.nextDouble();

        double percentage = (physics + chemistry + maths) / 3;

        String grade;
        String remarks;

        if (percentage >= 90) {
            grade = "A+";
            remarks = "Excellent";
        } else if (percentage >= 75) {
            grade = "A";
            remarks = "Very Good";
        } else if (percentage >= 60) {
            grade = "B";
            remarks = "Good";
        } else if (percentage >= 40) {
            grade = "C";
            remarks = "Pass";
        } else {
            grade = "F";
            remarks = "Fail";
        }

        System.out.println("Percentage = " + percentage);
        System.out.println("Grade = " + grade);
        System.out.println("Remarks = " + remarks);
    }
}