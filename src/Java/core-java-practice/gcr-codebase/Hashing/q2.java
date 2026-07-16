import java.util.HashMap;

public class MostFrequentErrorCode {

    // Function to find the most frequent error code
    public static int mostFrequentErrorCode(int[] codes) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        int bestCode = codes[0];
        int bestCount = 0;

        for (int code : codes) {

            int count = freq.getOrDefault(code, 0) + 1;
            freq.put(code, count);

            if (count > bestCount) {
                bestCount = count;
                bestCode = code;
            }
        }

        return bestCode;
    }

    public static void main(String[] args) {

        int[] codes = {404, 500, 404, 200, 500, 404, 403, 500, 404};

        int result = mostFrequentErrorCode(codes);

        System.out.println("Most Frequent Error Code: " + result);
    }
}
