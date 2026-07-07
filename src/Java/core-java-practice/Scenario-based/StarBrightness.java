import java.util.*;

public class StarBrightnessSearch {

    // 1. Normal Binary Search: O(log n)
    static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    // 2. Search in Rotated Sorted Array: O(log n)
    static int searchRotated(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) return mid;

            if (arr[low] <= arr[mid]) { // left side sorted
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // right side sorted
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    // 3. First occurrence: O(log n)
    static int firstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    // 4. Last occurrence: O(log n)
    static int lastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    // 5. Minimum element in rotated sorted array: O(log n)
    static int findMinimum(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return arr[low];
    }

    public static void main(String[] args) {

        int[] brightness = {1, 2, 3, 4, 5, 6, 7};
        int target = 5;

        System.out.println("Binary Search Index: " + binarySearch(brightness, target));

        int[] rotated = {5, 6, 7, 1, 2, 3, 4};

        System.out.println("Search in Rotated Catalog: " + searchRotated(rotated, 3));

        int[] repeated = {1, 2, 2, 2, 2, 3, 4, 5};

        int first = firstOccurrence(repeated, 2);
        int last = lastOccurrence(repeated, 2);

        System.out.println("First Occurrence: " + first);
        System.out.println("Last Occurrence: " + last);
        System.out.println("Total Occurrences: " + (last - first + 1));

        System.out.println("Minimum in Rotated Catalog: " + findMinimum(rotated));
    }
}
