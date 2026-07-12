public class SearchInSortedMatrix {

    public static boolean searchMatrix(
            int[][] matrix, int target) {

        if (matrix == null
                || matrix.length == 0
                || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0;
        int right = rows * columns - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int row = mid / columns;
            int column = mid % columns;

            int currentValue = matrix[row][column];

            if (currentValue == target) {
                return true;
            } else if (currentValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        int target = 16;

        boolean found = searchMatrix(matrix, target);

        if (found) {
            System.out.println(
                target + " is present in the matrix."
            );
        } else {
            System.out.println(
                target + " is not present in the matrix."
            );
        }
    }
}
