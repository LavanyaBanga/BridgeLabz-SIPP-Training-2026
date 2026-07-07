import java.util.*;

public class DetectiveAgency {

    // suspect -> case list
    static Map<String, List<String>> suspectCases = new HashMap<>();

    static void addRecord(String suspect, String caseName) {
        suspectCases.putIfAbsent(suspect, new ArrayList<>());
        suspectCases.get(suspect).add(caseName);
    }

    // 1. Most investigated suspect
    static String mostInvestigatedSuspect() {
        String ans = "";
        int maxCases = 0;

        for (String suspect : suspectCases.keySet()) {
            int count = suspectCases.get(suspect).size();

            if (count > maxCases) {
                maxCases = count;
                ans = suspect;
            }
        }

        return ans;
    }

    // 2. Suspects in exactly 2 cases
    static List<String> suspectsInExactlyTwoCases() {
        List<String> ans = new ArrayList<>();

        for (String suspect : suspectCases.keySet()) {
            if (suspectCases.get(suspect).size() == 2) {
                ans.add(suspect);
            }
        }

        return ans;
    }

    // 3. Pair of suspects always seen together
    static List<String> alwaysSeenTogetherPairs() {
        List<String> suspects = new ArrayList<>(suspectCases.keySet());
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < suspects.size(); i++) {
            for (int j = i + 1; j < suspects.size(); j++) {

                String s1 = suspects.get(i);
                String s2 = suspects.get(j);

                Set<String> cases1 = new HashSet<>(suspectCases.get(s1));
                Set<String> cases2 = new HashSet<>(suspectCases.get(s2));

                if (cases1.equals(cases2)) {
                    ans.add(s1 + " & " + s2);
                }
            }
        }

        return ans;
    }

    // 4. Subarray with sum equal to K using prefix sum + HashMap
    static int[] subarraySumK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // prefixSum -> index
        map.put(0, -1);

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (map.containsKey(prefixSum - k)) {
                int start = map.get(prefixSum - k) + 1;
                int end = i;

                return new int[]{start, end};
            }

            map.put(prefixSum, i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        addRecord("Ravi", "Case1");
        addRecord("Ravi", "Case2");
        addRecord("Ravi", "Case3");

        addRecord("Aman", "Case1");
        addRecord("Aman", "Case2");

        addRecord("Neha", "Case1");
        addRecord("Neha", "Case2");

        addRecord("Karan", "Case4");

        System.out.println("Suspect Cases:");
        System.out.println(suspectCases);

        System.out.println("Most Investigated Suspect:");
        System.out.println(mostInvestigatedSuspect());

        System.out.println("Suspects in Exactly 2 Cases:");
        System.out.println(suspectsInExactlyTwoCases());

        System.out.println("Always Seen Together Pairs:");
        System.out.println(alwaysSeenTogetherPairs());

        int[] nums = {10, 2, -2, -20, 10};
        int k = -10;

        int[] ans = subarraySumK(nums, k);

        System.out.println("Subarray with Sum K:");
        System.out.println(Arrays.toString(ans));
    }
}
