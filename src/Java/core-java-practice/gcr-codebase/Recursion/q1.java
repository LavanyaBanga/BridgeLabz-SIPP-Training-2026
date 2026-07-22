import java.util.ArrayList;
import java.util.List;

public class FeatureFlagCombinations {

    public static List<List<String>> generateFlagCombinations(String[] flags) {
        List<List<String>> allCombinations = new ArrayList<>();

        generateCombinations(
                flags,
                0,
                new ArrayList<>(),
                allCombinations
        );

        return allCombinations;
    }

    private static void generateCombinations(
            String[] flags,
            int currentIndex,
            List<String> currentCombination,
            List<List<String>> allCombinations
    ) {

       
        if (currentIndex == flags.length) {
            allCombinations.add(new ArrayList<>(currentCombination));
            return;
        }

        // Choice 1: Current feature flag is ON
        currentCombination.add(flags[currentIndex]);

        generateCombinations(
                flags,
                currentIndex + 1,
                currentCombination,
                allCombinations
        );

      
        currentCombination.remove(currentCombination.size() - 1);
        generateCombinations(
                flags,
                currentIndex + 1,
                currentCombination,
                allCombinations
        );
    }

    public static void main(String[] args) {

        String[] featureFlags = {
                "Dark Mode",
                "New Checkout",
                "Beta Search"
        };

        List<List<String>> combinations =
                generateFlagCombinations(featureFlags);

        System.out.println("All possible feature flag combinations:");

        for (int i = 0; i < combinations.size(); i++) {
            System.out.println((i + 1) + ". " + combinations.get(i));
        }

        System.out.println("\nTotal combinations: " + combinations.size());
    }
}
