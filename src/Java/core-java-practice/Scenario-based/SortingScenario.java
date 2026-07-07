import java.util.*;

public class SortingScenario {

    // MERGE SORT
    static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;

        int mid = l + (r - l) / 2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        merge(arr, l, mid, r);
    }

    // O(n) merge step
    static void merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];

        int i = l;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        for (int x = 0; x < temp.length; x++) {
            arr[l + x] = temp[x];
        }
    }

    // QUICK SORT WITH LOMUTO PARTITION
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = lomutoPartition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int lomutoPartition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // COUNTING SORT FOR GENRE CODES 1 TO 20
    static void countingSort(int[] arr) {
        int[] count = new int[21];

        for (int x : arr) {
            count[x]++;
        }

        int index = 0;

        for (int genre = 1; genre <= 20; genre++) {
            while (count[genre] > 0) {
                arr[index++] = genre;
                count[genre]--;
            }
        }
    }

    static int[] generateRandomArray(int n, int maxValue) {
        Random rand = new Random();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(maxValue) + 1;
        }

        return arr;
    }

    static int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }

        return copy;
    }

    public static void main(String[] args) {

        int[] sizes = {100, 1000, 10000};

        for (int n : sizes) {

            int[] years = generateRandomArray(n, 2026);
            int[] genres = generateRandomArray(n, 20);

            int[] mergeArr = copyArray(years);
            int[] quickArr = copyArray(years);
            int[] countArr = copyArray(genres);

            long start, end;

            start = System.nanoTime();
            mergeSort(mergeArr, 0, mergeArr.length - 1);
            end = System.nanoTime();
            long mergeTime = end - start;

            start = System.nanoTime();
            quickSort(quickArr, 0, quickArr.length - 1);
            end = System.nanoTime();
            long quickTime = end - start;

            start = System.nanoTime();
            countingSort(countArr);
            end = System.nanoTime();
            long countTime = end - start;

            System.out.println("Size: " + n);
            System.out.println("Merge Sort Time: " + mergeTime + " ns");
            System.out.println("Quick Sort Time: " + quickTime + " ns");
            System.out.println("Counting Sort Time: " + countTime + " ns");
            System.out.println("-------------------------");
        }
    }
}
