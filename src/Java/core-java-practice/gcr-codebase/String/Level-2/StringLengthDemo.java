import java.util.Scanner;

public class StringLengthDemo {

    public static int findLength(String str) {
        int count = 0;

        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String: ");
        String text = sc.next();

        System.out.println("User Length = " + findLength(text));
        System.out.println("Built-in Length = " + text.length());

        sc.close();
    }
}