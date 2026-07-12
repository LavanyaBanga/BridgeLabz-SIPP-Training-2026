import java.util.HashMap;
import java.util.Map;

public class MinimumLogWindow {

    public static String minWindowSubstring(
            String log, String requiredCodes) {

        if (log == null
                || requiredCodes == null
                || log.isEmpty()
                || requiredCodes.isEmpty()
                || requiredCodes.length() > log.length()) {

            return "";
        }

        Map<Character, Integer> requiredFrequency =
            new HashMap<>();

        for (char character : requiredCodes.toCharArray()) {
            requiredFrequency.put(
                character,
                requiredFrequency.getOrDefault(
                    character, 0
                ) + 1
            );
        }

        Map<Character, Integer> windowFrequency =
            new HashMap<>();

        int requiredCharacters =
            requiredFrequency.size();

        int formedCharacters = 0;
        int windowStart = 0;

        int minimumLength = Integer.MAX_VALUE;
        int minimumStart = 0;

        for (int windowEnd = 0;
             windowEnd < log.length();
             windowEnd++) {

            char currentCharacter =
                log.charAt(windowEnd);

            windowFrequency.put(
                currentCharacter,
                windowFrequency.getOrDefault(
                    currentCharacter, 0
                ) + 1
            );

            if (requiredFrequency.containsKey(currentCharacter)
                    && windowFrequency.get(currentCharacter)
                    .intValue()
                    == requiredFrequency.get(currentCharacter)
                    .intValue()) {

                formedCharacters++;
            }

            while (formedCharacters == requiredCharacters) {

                int currentLength =
                    windowEnd - windowStart + 1;

                if (currentLength < minimumLength) {
                    minimumLength = currentLength;
                    minimumStart = windowStart;
                }

                char leftCharacter =
                    log.charAt(windowStart);

                windowFrequency.put(
                    leftCharacter,
                    windowFrequency.get(leftCharacter) - 1
                );

                if (requiredFrequency.containsKey(leftCharacter)
                        && windowFrequency.get(leftCharacter)
                        < requiredFrequency.get(leftCharacter)) {

                    formedCharacters--;
                }

                windowStart++;
            }
        }

        if (minimumLength == Integer.MAX_VALUE) {
            return "";
        }

        return log.substring(
            minimumStart,
            minimumStart + minimumLength
        );
    }

    public static void main(String[] args) {
        String log = "ADOBECODEBANC";
        String requiredCodes = "ABC";

        String result =
            minWindowSubstring(log, requiredCodes);

        if (result.isEmpty()) {
            System.out.println(
                "No matching log window found."
            );
        } else {
            System.out.println(
                "Minimum log window: " + result
            );
        }
    }
}
