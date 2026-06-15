import java.util.Scanner;

public class FirstNon {

    public static char findFirstNonRepeating(String text) {

        int[] freq = new int[256];

        // Step 1: frequency count
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        // Step 2: find first non-repeating
        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '_'; // if none found
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        char result = findFirstNonRepeating(text);

        if (result == '_') {
            System.out.println("No non-repeating character found");
        } else {
            System.out.println("First Non-Repeating Character = " + result);
        }

        sc.close();
    }
}