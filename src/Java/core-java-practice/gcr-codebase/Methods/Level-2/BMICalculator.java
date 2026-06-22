import java.util.Scanner;

public class BMICalculator {

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];

            double heightMeter = heightCm / 100;
            double bmi = weight / (heightMeter * heightMeter);

            data[i][2] = bmi;
        }
    }

    public static String[] findBMIStatus(double[][] data) {
        String[] status = new String[data.length];

        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];

            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi < 25) {
                status[i] = "Normal";
            } else if (bmi < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] data = new double[10][3];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight in kg for person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();

            System.out.print("Enter height in cm for person " + (i + 1) + ": ");
            data[i][1] = sc.nextDouble();
        }

        calculateBMI(data);
        String[] status = findBMIStatus(data);

        System.out.println("Weight\tHeight\tBMI\tStatus");

        for (int i = 0; i < 10; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1] + "\t" + data[i][2] + "\t" + status[i]);
        }
    }
}