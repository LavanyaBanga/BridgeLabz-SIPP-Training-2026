import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServerLoadTriplets {

    public static List<List<Integer>> findTriplets(
            int[] jobs, int target) {

        Arrays.sort(jobs);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < jobs.length - 2; i++) {

            if (i > 0 && jobs[i] == jobs[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = jobs.length - 1;

            while (left < right) {
                int currentSum =
                    jobs[i] + jobs[left] + jobs[right];

                if (currentSum == target) {
                    result.add(
                        Arrays.asList(
                            jobs[i],
                            jobs[left],
                            jobs[right]
                        )
                    );

                    while (left < right
                            && jobs[left] == jobs[left + 1]) {
                        left++;
                    }

                    while (left < right
                            && jobs[right] == jobs[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] jobs = {
            100, 200, 300, 400, 500, 300
        };

        int target = 900;

        List<List<Integer>> triplets =
            findTriplets(jobs, target);

        if (triplets.isEmpty()) {
            System.out.println("No valid triplet found.");
        } else {
            System.out.println(
                "Valid job triplets: " + triplets
            );
        }
    }
}
