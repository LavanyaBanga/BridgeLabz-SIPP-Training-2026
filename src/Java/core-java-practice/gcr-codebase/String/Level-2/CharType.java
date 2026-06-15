import java.util.Scanner;

public class CharType {

    public static String checkChar(char ch) {

        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                return "Vowel";
            else
                return "Consonant";
        }

        return "Not a Letter";
    }

    public static String[][] analyzeString(String text) {

        String[][] result = new String[text.length()][2];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            result[i][0] = String.valueOf(ch);
            result[i][1] = checkChar(ch);
        }

        return result;
    }

    public static void display(String[][] arr) {

        System.out.println("Char\tType");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + "\t" + arr[i][1]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String[][] result = analyzeString(text);

        display(result);

        sc.close();
    }
}