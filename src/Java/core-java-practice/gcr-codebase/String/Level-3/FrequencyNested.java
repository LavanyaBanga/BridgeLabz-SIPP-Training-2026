import java.util.Scanner;

public class FrequencyNested {

    public static String[][] findFrequency(String text) {

        char[] arr = text.toCharArray();
        int n = arr.length;

        int[] freq = new int[n];
        String[][] result = new String[n][2];

        for (int i = 0; i < n; i++) {
            freq[i] = 1;

            if (arr[i] == '0') continue;

            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    freq[i]++;
                    arr[j] = '0';
                }
            }
        }

        int index = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] != '0') {
                result[index][0] = String.valueOf(arr[i]);
                result[index][1] = String.valueOf(freq[i]);
                index++;
            }
        }

        String[][] finalResult = new String[index][2];

        for (int i = 0; i < index; i++) {
            finalResult[i][0] = result[i][0];
            finalResult[i][1] = result[i][1];
        }

        return finalResult;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String[][] res = findFrequency(text);

        System.out.println("Char\tFreq");

        for (String[] r : res) {
            System.out.println(r[0] + "\t" + r[1]);
        }
    }
}