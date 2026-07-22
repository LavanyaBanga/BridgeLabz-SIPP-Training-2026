import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendingMachineChange {

    public static List<List<Integer>> makeChange(int[] coins, int target) {
        Arrays.sort(coins);

        List<List<Integer>> allCombinations = new ArrayList<>();

        findCombinations(
                coins,
                target,
                0,
                0,
                new ArrayList<>(),
                allCombinations
        );

        return allCombinations;
    }

    private static void findCombinations(
            int[] coins,
            int target,
            int startIndex,
            int currentSum,
            List<Integer> currentCombination,
            List<List<Integer>> allCombinations
    ) {

       
        if (currentSum == target) {
            allCombinations.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = startIndex; i < coins.length; i++) {

         
            if (i > startIndex && coins[i] == coins[i - 1]) {
                continue;
            }

        
            if (currentSum + coins[i] > target) {
                break;
            }

       
            currentCombination.add(coins[i]);

       
            findCombinations(
                    coins,
                    target,
                    i,
                    currentSum + coins[i],
                    currentCombination,
                    allCombinations
            );

            
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] coinDenominations = {1, 2, 5};
        int refundAmount = 5;

        List<List<Integer>> combinations =
                makeChange(coinDenominations, refundAmount);

        System.out.println("Ways to make refund amount:");

        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }

        System.out.println("Total combinations: " + combinations.size());
    }
}
