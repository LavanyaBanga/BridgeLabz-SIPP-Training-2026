import java.util.Arrays;

public class StarBrightnessCatalog {

    // Normal binary search in a sorted array
    public static int binarySearch(int[] brightness, int target) {
        int left = 0;
        int right = brightness.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (brightness[mid] == target) {
                return mid;
            } else if (brightness[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // Search target in a rotated sorted array
    public static int searchInRotatedArray(int[] brightness, int target) {
        int left = 0;
        int right = brightness.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (brightness[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (brightness[left] <= brightness[mid]) {

                if (target >= brightness[left]
                        && target < brightness[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {
                // Right half is sorted

                if (target > brightness[mid]
                        && target <= brightness[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    // Find first occurrence
    public static int findFirstOccurrence(
            int[] brightness, int target) {

        int left = 0;
        int right = brightness.length - 1;
        int firstIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (brightness[mid] == target) {
                firstIndex = mid;
                right = mid - 1;
            } else if (brightness[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return firstIndex;
    }

    // Find last occurrence
    public static int findLastOccurrence(
            int[] brightness, int target) {

        int left = 0;
        int right = brightness.length - 1;
        int lastIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (brightness[mid] == target) {
                lastIndex = mid;
                left = mid + 1;
            } else if (brightness[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return lastIndex;
    }

    // Find minimum element in rotated sorted array
    public static int findMinimum(int[] brightness) {
        int left = 0;
        int right = brightness.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (brightness[mid] > brightness[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return brightness[left];
    }

    public static void main(String[] args) {

        int[] sortedBrightness = {
            10, 20, 30, 30, 30, 40, 50, 60
        };

        int target = 30;

        int index = binarySearch(sortedBrightness, target);
        System.out.println("Target index: " + index);

        int firstIndex =
            findFirstOccurrence(sortedBrightness, target);

        int lastIndex =
            findLastOccurrence(sortedBrightness, target);

        System.out.println(
            "First and last occurrence: "
            + Arrays.toString(
                new int[]{firstIndex, lastIndex}
            )
        );

        int[] rotatedBrightness = {
            40, 50, 60, 10, 20, 30
        };

        int rotatedIndex =
            searchInRotatedArray(rotatedBrightness, 20);

        System.out.println(
            "Target index in rotated catalog: "
            + rotatedIndex
        );

        System.out.println(
            "Minimum brightness: "
            + findMinimum(rotatedBrightness)
        );
    }
}
