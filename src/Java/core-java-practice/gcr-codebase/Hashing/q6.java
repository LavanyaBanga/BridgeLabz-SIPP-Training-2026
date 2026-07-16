import java.util.HashSet;

public class LongestConsecutiveRun {

    // Function to find longest consecutive sequence
    public static int longestConsecutiveRun(int[] ids) {

        HashSet<Integer> idSet = new HashSet<>();

        // Store all IDs in HashSet
        for (int id : ids) {
            idSet.add(id);
        }

        int longest = 0;

        // Find longest consecutive run
        for (int id : idSet) {

            // Start only if there is no predecessor
            if (!idSet.contains(id - 1)) {

                int current = id;
                int length = 1;

                while (idSet.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        int[] ids = {100, 4, 200, 1, 3, 2};

        int result = longestConsecutiveRun(ids);

        System.out.println("Longest Consecutive Run Length: " + result);
    }
}
