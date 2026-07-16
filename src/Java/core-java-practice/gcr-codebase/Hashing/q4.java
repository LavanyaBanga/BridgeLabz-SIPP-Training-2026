import java.util.HashMap;

public class SubarraySum {

    // Function to count subarrays whose sum equals k
    public static int subarraySumEqualsK(int[] revenueChanges, int k) {

        HashMap<Integer, Integer> prefixCount = new HashMap<>();

        // Initialize with sum 0 occurring once
        prefixCount.put(0, 1);

        int runningSum = 0;
        int answer = 0;

        for (int change : revenueChanges) {

            runningSum += change;

            // Check if (runningSum - k) exists
            answer += prefixCount.getOrDefault(runningSum - k, 0);

            // Store/update current prefix sum
            prefixCount.put(runningSum,
                    prefixCount.getOrDefault(runningSum, 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] revenueChanges = {1, 2, 3, -2, 2, -3, 3};
        int k = 3;

        int result = subarraySumEqualsK(revenueChanges, k);

        System.out.println("Number of Subarrays = " + result);
    }
}
