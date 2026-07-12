public class RotationPoint {

    public static int findRotationPoint(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] numbers = {
            40, 50, 60, 70, 10, 20, 30
        };

        int rotationIndex =
            findRotationPoint(numbers);

        System.out.println(
            "Rotation point index: " + rotationIndex
        );

        if (rotationIndex != -1) {
            System.out.println(
                "Smallest element: "
                + numbers[rotationIndex]
            );
        }
    }
}
