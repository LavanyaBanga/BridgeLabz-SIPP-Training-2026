import java.util.Random;
import java.util.Scanner;

public class RPSHiring {

    public static String computerChoice() {

        String[] arr = {"Rock", "Paper", "Scissors"};
        return arr[new Random().nextInt(3)];
    }

    public static String winner(String user, String comp) {

        if (user.equals(comp))
            return "Draw";

        if (user.equals("Rock") && comp.equals("Scissors")) return "User";
        if (user.equals("Paper") && comp.equals("Rock")) return "User";
        if (user.equals("Scissors") && comp.equals("Paper")) return "User";

        return "Computer";
    }

    public static String[][] playGame(int n) {

        String[][] result = new String[n][4];

        int userWin = 0, compWin = 0;

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < n; i++) {

            System.out.print("Enter Rock/Paper/Scissors: ");
            String user = sc.next();

            String comp = computerChoice();

            String win = winner(user, comp);

            if (win.equals("User")) userWin++;
            else if (win.equals("Computer")) compWin++;

            result[i][0] = user;
            result[i][1] = comp;
            result[i][2] = win;
            result[i][3] = "";
        }

        double userPct = (userWin * 100.0) / n;
        double compPct = (compWin * 100.0) / n;

        System.out.println("\nUser Win % = " + userPct);
        System.out.println("Computer Win % = " + compPct);

        return result;
    }

    public static void display(String[][] data) {

        System.out.println("User\tComputer\tWinner");

        for (String[] row : data) {
            System.out.println(row[0] + "\t" + row[1] + "\t\t" + row[2]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int n = sc.nextInt();

        String[][] result = playGame(n);

        display(result);
    }
}