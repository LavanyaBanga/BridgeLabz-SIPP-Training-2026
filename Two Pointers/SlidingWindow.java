import java.util.Arrays;

public class PairSumFraudDetection {

    public static int[] findPairSum(int[] transactions, int target) {
        int left = 0;
        int right = transactions.length - 1;

        while (left < right) {
            int currentSum = transactions[left] + transactions[right];

            if (currentSum == target) {
                return new int[]{
                    transactions[left],
                    transactions[right]
                };
            }

            if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] transactions = {
            1000, 5000, 15000, 20000, 34999
        };

        int target = 49999;

        int[] result = findPairSum(transactions, target);

        if (result[0] == -1) {
            System.out.println("No suspicious pair found.");
        } else {
            System.out.println(
                "Suspicious transaction pair: "
                + Arrays.toString(result)
            );
        }
    }
}
