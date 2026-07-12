public class PeakElement {

    public static int findPeakElement(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] < numbers[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] numbers = {
            1, 3, 5, 7, 6, 4, 2
        };

        int peakIndex = findPeakElement(numbers);

        System.out.println(
            "Peak element index: " + peakIndex
        );

        System.out.println(
            "Peak element: " + numbers[peakIndex]
        );
    }
}
