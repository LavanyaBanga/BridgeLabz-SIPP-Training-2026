import java.util.Scanner;

public class CharFrequency {

    public static String[][] findFrequency(String text) {

        int[] freq = new int[256];

        // Step 1: count frequency
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        // Step 2: count unique characters
        int count = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                count++;
            }
        }

        // Step 3: store in 2D array
        String[][] result = new String[count][2];

        int index = 0;

        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[index][0] = String.valueOf((char) i);
                result[index][1] = String.valueOf(freq[i]);
                index++;
            }
        }

        return result;
    }

    public static void display(String[][] arr) {

        System.out.println("Char\tFrequency");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + "\t" + arr[i][1]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String[][] result = findFrequency(text);

        display(result);

        sc.close();
    }
}