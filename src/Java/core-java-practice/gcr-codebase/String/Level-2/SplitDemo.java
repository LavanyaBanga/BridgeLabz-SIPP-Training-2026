import java.util.Scanner;

public class SplitDemo {

    public static String[] splitWords(String text) {

        int words = 1;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                words++;
            }
        }

        String[] result = new String[words];

        String word = "";
        int index = 0;

        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) == ' ') {
                result[index++] = word;
                word = "";
            } else {
                word += text.charAt(i);
            }
        }

        result[index] = word;

        return result;
    }

    public static boolean compareArrays(String[] a, String[] b) {

        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i]))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Text: ");
        String text = sc.nextLine();

        String[] userWords = splitWords(text);
        String[] builtInWords = text.split(" ");

        System.out.println("Same Result ? "
                + compareArrays(userWords, builtInWords));

        sc.close();
    }
}