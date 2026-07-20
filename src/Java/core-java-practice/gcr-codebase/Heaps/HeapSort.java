class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDownMax(arr, i, n);
        }

        
        for (int end = n - 1; end > 0; end--) {

         
            int temp = arr[0];
            arr[0] = arr[end];
            arr[end] = temp;

           
            siftDownMax(arr, 0, end);
        }
    }

    public static void siftDownMax(int[] arr, int i, int size) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            siftDownMax(arr, largest, size);
        }
    }

    
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] readings = {40, 10, 30, 50, 60, 15, 20};

        System.out.println("Original Array:");
        printArray(readings);

        heapSort(readings);

        System.out.println("Sorted Array:");
        printArray(readings);
    }
}
