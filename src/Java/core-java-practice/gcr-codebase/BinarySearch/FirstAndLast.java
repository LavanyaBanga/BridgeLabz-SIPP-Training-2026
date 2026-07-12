import java.util.Arrays;

public class FirstAndLastOccurrence {

    public static int findFirstOccurrence(
            int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;
        int firstIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] == target) {
                firstIndex = mid;

                // Continue searching on the left
                right = mid - 1;

            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return firstIndex;
    }

    public static int findLastOccurrence(
            int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;
        int lastIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] == target) {
                lastIndex = mid;

                // Continue searching on the right
                left = mid + 1;

            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return lastIndex;
    }

    public static int[] findRange(
            int[] numbers, int target) {

        int firstIndex =
            findFirstOccurrence(numbers, target);

        int lastIndex =
            findLastOccurrence(numbers, target);

        return new int[]{firstIndex, lastIndex};
    }

    public static void main(String[] args) {
        int[] numbers = {
            2, 4, 4, 4, 4, 7, 9, 10
        };

        int target = 4;

        int[] result = findRange(numbers, target);

        System.out.println(
            "First and last occurrence: "
            + Arrays.toString(result)
        );
    }
}
