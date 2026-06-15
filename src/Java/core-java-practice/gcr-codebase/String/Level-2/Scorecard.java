import java.util.Random;

public class Scorecard {

    public static int[][] generateScores(int n) {

        Random r = new Random();
        int[][] marks = new int[n][3];

        for (int i = 0; i < n; i++) {
            marks[i][0] = 40 + r.nextInt(61);
            marks[i][1] = 40 + r.nextInt(61);
            marks[i][2] = 40 + r.nextInt(61);
        }

        return marks;
    }

    public static double[][] calculate(int[][] marks) {

        double[][] res = new double[marks.length][4];

        for (int i = 0; i < marks.length; i++) {

            int total = marks[i][0] + marks[i][1] + marks[i][2];

            double avg = total / 3.0;
            double percent = total / 3.0;

            res[i][0] = total;
            res[i][1] = Math.round(avg * 100.0) / 100.0;
            res[i][2] = Math.round(percent * 100.0) / 100.0;
        }

        return res;
    }

    public static String[] grade(double[][] data) {

        String[] g = new String[data.length];

        for (int i = 0; i < data.length; i++) {

            double p = data[i][2];

            if (p >= 90) g[i] = "A";
            else if (p >= 75) g[i] = "B";
            else if (p >= 60) g[i] = "C";
            else if (p >= 40) g[i] = "D";
            else g[i] = "F";
        }

        return g;
    }

    public static void display(int[][] marks, double[][] data, String[] g) {

        System.out.println("Phy\tChem\tMath\tTotal\tAvg\tPercent\tGrade");

        for (int i = 0; i < marks.length; i++) {

            System.out.println(
                    marks[i][0] + "\t" +
                            marks[i][1] + "\t" +
                            marks[i][2] + "\t" +
                            data[i][0] + "\t" +
                            data[i][1] + "\t" +
                            data[i][2] + "\t" +
                            g[i]);
        }
    }

    public static void main(String[] args) {

        int n = 5;

        int[][] marks = generateScores(n);

        double[][] data = calculate(marks);

        String[] g = grade(data);

        display(marks, data, g);
    }
}