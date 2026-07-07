import java.util.*;

public class RiverStationProblems {

    // 1. Longest contiguous period where max - min <= range
    // Variable Sliding Window: O(n)
    static int longestWithinRange(int[] levels, int range) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < levels.length; right++) {

            while (!maxDeque.isEmpty() && levels[maxDeque.peekLast()] < levels[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            while (!minDeque.isEmpty() && levels[minDeque.peekLast()] > levels[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            while (levels[maxDeque.peekFirst()] - levels[minDeque.peekFirst()] > range) {
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // 2. Unique triplets whose sum is zero
    // Two Pointer after sorting: O(n^2)
    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return ans;
    }

    // 3. Maximum average subarray of length k
    // Fixed Sliding Window: O(n)
    static double maxAverageSubarray(int[] nums, int k) {
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args) {

        int[] waterLevels = {8, 2, 4, 7};
        int range = 4;

        System.out.println("Longest Period Within Range: " +
                longestWithinRange(waterLevels, range));

        int[] pollution = {-1, 0, 1, 2, -1, -4};

        System.out.println("Unique Triplets Sum Zero: " +
                threeSum(pollution));

        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        System.out.println("Max Average Subarray: " +
                maxAverageSubarray(nums, k));
    }
}
