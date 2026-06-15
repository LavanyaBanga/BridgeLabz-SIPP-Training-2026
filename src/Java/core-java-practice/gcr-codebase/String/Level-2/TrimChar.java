import java.util.Scanner;

public class TrimChar {

    public static int[] trimIndexes(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start < text.length() && text.charAt(start) == ' ')
            start++;

        while (end >= 0 && text.charAt(end) == ' ')
            end--;

        return new int[]{start, end};
    }

    public static String substringCustom(String text, int start, int end) {

        String res = "";

        for (int i = start; i <= end; i++) {
            res += text.charAt(i);
        }

        return res;
    }

    public static boolean compare(String a, String b) {

        if (a.length() != b.length())
            return false;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        int[] idx = trimIndexes(text);

        String userTrim = substringCustom(text, idx[0], idx[1]);
        String builtIn = text.trim();

        System.out.println("User Trim: [" + userTrim + "]");
        System.out.println("Built-in Trim: [" + builtIn + "]");

        System.out.println("Same? " + compare(userTrim, builtIn));

        sc.close();
    }
}