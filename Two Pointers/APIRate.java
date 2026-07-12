import java.util.HashMap;
import java.util.Map;

public class ApiRateLimiterWindow {

    public static int longestSubarrayWithAtMostNDistinct(
            int[] keyIds, int maximumDistinctKeys) {

        if (keyIds == null
                || keyIds.length == 0
                || maximumDistinctKeys <= 0) {

            return 0;
        }

        Map<Integer, Integer> keyFrequency =
            new HashMap<>();

        int windowStart = 0;
        int maximumLength = 0;

        for (int windowEnd = 0;
             windowEnd < keyIds.length;
             windowEnd++) {

            int currentKey = keyIds[windowEnd];

            keyFrequency.put(
                currentKey,
                keyFrequency.getOrDefault(
                    currentKey, 0
                ) + 1
            );

            while (keyFrequency.size()
                    > maximumDistinctKeys) {

                int leftKey = keyIds[windowStart];

                keyFrequency.put(
                    leftKey,
                    keyFrequency.get(leftKey) - 1
                );

                if (keyFrequency.get(leftKey) == 0) {
                    keyFrequency.remove(leftKey);
                }

                windowStart++;
            }

            int currentLength =
                windowEnd - windowStart + 1;

            maximumLength = Math.max(
                maximumLength,
                currentLength
            );
        }

        return maximumLength;
    }

    public static void main(String[] args) {
        int[] apiKeyIds = {
            1, 2, 1, 2, 3, 2, 2
        };

        int maximumDistinctKeys = 2;

        int result =
            longestSubarrayWithAtMostNDistinct(
                apiKeyIds,
                maximumDistinctKeys
            );

        System.out.println(
            "Longest request sequence with at most "
            + maximumDistinctKeys
            + " distinct keys: "
            + result
        );
    }
}
