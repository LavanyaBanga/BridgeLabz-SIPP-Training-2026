import java.util.Random;

public class Voting2d {

    public static int[] generateAges(int n) {

        Random r = new Random();
        int[] ages = new int[n];

        for (int i = 0; i < n; i++) {
            ages[i] = r.nextInt(40); // 0–39
        }

        return ages;
    }

    public static String[][] checkVote(int[] ages) {

        String[][] res = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {

            res[i][0] = String.valueOf(ages[i]);

            if (ages[i] < 0)
                res[i][1] = "Invalid / Cannot Vote";
            else if (ages[i] >= 18)
                res[i][1] = "Can Vote";
            else
                res[i][1] = "Cannot Vote";
        }

        return res;
    }

    public static void display(String[][] data) {

        System.out.println("Age\tStatus");

        for (String[] row : data) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }

    public static void main(String[] args) {

        int[] ages = generateAges(10);

        String[][] result = checkVote(ages);

        display(result);
    }
}