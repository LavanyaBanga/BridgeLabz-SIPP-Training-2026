import java.util.*;

public class StockExchangeHeap {

    // =========================
    // 1. MAX HEAP FROM SCRATCH
    // =========================

    static class MaxHeap {
        int[] heap;
        int size;

        MaxHeap(int capacity) {
            heap = new int[capacity];
            size = 0;
        }

        void insert(int value) {
            heap[size] = value;
            int index = size;
            size++;

            while (index > 0) {
                int parent = (index - 1) / 2;

                if (heap[parent] < heap[index]) {
                    swap(parent, index);
                    index = parent;
                } else {
                    break;
                }
            }
        }

        int extractMax() {
            if (size == 0) return -1;

            int max = heap[0];

            heap[0] = heap[size - 1];
            size--;

            heapifyDown(0);

            return max;
        }

        void heapifyDown(int index) {
            int largest = index;

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < size && heap[left] > heap[largest]) {
                largest = left;
            }

            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }

            if (largest != index) {
                swap(index, largest);
                heapifyDown(largest);
            }
        }

        void buildHeap(int[] arr) {
            size = arr.length;

            for (int i = 0; i < arr.length; i++) {
                heap[i] = arr[i];
            }

            for (int i = size / 2 - 1; i >= 0; i--) {
                heapifyDown(i);
            }
        }

        void printHeap() {
            for (int i = 0; i < size; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println();
        }

        void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }

    // ==========================================
    // 2. TOP-K PERFORMING STOCKS USING PRIORITYQUEUE
    // ==========================================

    static int[] topKStocks(int[] marketCaps, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int cap : marketCaps) {
            pq.offer(cap);
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }

    // =========================
    // 3. HEAP SORT
    // =========================

    static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract max one by one
        for (int i = n - 1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {

            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {

        int[] marketCaps = {500, 1200, 300, 900, 1500, 700};

        MaxHeap heap = new MaxHeap(marketCaps.length);

        heap.buildHeap(marketCaps);

        System.out.println("Max Heap:");
        heap.printHeap();

        System.out.println("Extract Max:");
        System.out.println(heap.extractMax());

        System.out.println("Heap after extracting max:");
        heap.printHeap();

        int k = 3;

        System.out.println("Top " + k + " Stocks:");
        System.out.println(Arrays.toString(topKStocks(marketCaps, k)));

        int[] arr = {500, 1200, 300, 900, 1500, 700};

        heapSort(arr);

        System.out.println("Heap Sort Ascending:");
        System.out.println(Arrays.toString(arr));
    }
}
