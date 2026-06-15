import java.util.Scanner;

public class Spy {
    public static String reverse(String s) {
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        return rev;
    }


    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }


    public static int[] countVC(String s) {

        int vowels = 0, consonants = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch >= 'A' && ch <= 'Z')
                ch = (char)(ch + 32);

            if (ch >= 'a' && ch <= 'z') {

                if (ch == 'a' || ch == 'e' || ch == 'i' ||
                        ch == 'o' || ch == 'u')
                    vowels++;
                else
                    consonants++;
            }
        }

        return new int[]{vowels, consonants};
    }


    public static boolean isAnagram(String a, String b) {

        if (a.length() != b.length())
            return false;

        int[] freq = new int[256];

        for (int i = 0; i < a.length(); i++) {
            freq[a.charAt(i)]++;
            freq[b.charAt(i)]--;
        }

        for (int i = 0; i < 256; i++) {
            if (freq[i] != 0)
                return false;
        }

        return true;
    }


    public static char firstNonRepeating(String s) {

        int[] freq = new int[256];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)] == 1)
                return s.charAt(i);
        }

        return '_'; // none
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.print("Enter secret message: ");
        String msg = sc.nextLine();


        String reversed = reverse(msg);
        System.out.println("\nReversed Message: " + reversed);


        System.out.println("Palindrome: " + isPalindrome(msg));


        int[] vc = countVC(msg);
        System.out.println("Vowels = " + vc[0]);
        System.out.println("Consonants = " + vc[1]);


        System.out.print("\nEnter second message for anagram check: ");
        String msg2 = sc.nextLine();

        System.out.println("Anagram: " + isAnagram(msg, msg2));

        // First non-repeating character
        char ch = firstNonRepeating(msg);

        if (ch == '_')
            System.out.println("No non-repeating character found");
        else
            System.out.println("First Non-Repeating Character: " + ch);

        sc.close();
    }
}