public class Hanoi {

    static int moves = 0;


    public static void hanoi(int n, char src, char helper, char dest) {
        if (n == 0) {
            return;
        }

        hanoi(n - 1, src, dest, helper);

        System.out.println("Move disk " + n + " from " + src + " to " + dest);
        moves++;

        hanoi(n - 1, helper, src, dest);
    }


    public static int binarySearch(int[] arr, int si, int ei, int target) {
        if (si > ei) {
            return -1;
        }

        int mid = si + (ei - si) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (target < arr[mid]) {
            return binarySearch(arr, si, mid - 1, target);
        } else {
            return binarySearch(arr, mid + 1, ei, target);
        }
    }


    public static int sumDigits(int n) {
        if (n == 0) {
            return 0;
        }

        return (n % 10) + sumDigits(n / 10);
    }


    public static String reverse(String s) {
        if (s.length() == 0) {
            return "";
        }

        return reverse(s.substring(1)) + s.charAt(0);
    }


    public static boolean isBalanced(String s, int idx, int count) {
        if (count < 0) {
            return false;
        }

        if (idx == s.length()) {
            return count == 0;
        }

        if (s.charAt(idx) == '(') {
            return isBalanced(s, idx + 1, count + 1);
        } else if (s.charAt(idx) == ')') {
            return isBalanced(s, idx + 1, count - 1);
        }

        return isBalanced(s, idx + 1, count);
    }

    public static void main(String[] args) {

        System.out.println("Tower of Hanoi:");
        hanoi(3, 'A', 'B', 'C');
        System.out.println("Total Moves = " + moves);

        int[] prices = {100, 200, 300, 400, 500};
        System.out.println("\nBinary Search:");
        System.out.println("Index = " +
                binarySearch(prices, 0, prices.length - 1, 300));

        System.out.println("\nSum of Digits:");
        System.out.println(sumDigits(1234));

        System.out.println("\nReverse String:");
        System.out.println(reverse("Lavanya"));

        System.out.println("\nBalanced Parentheses:");
        System.out.println(isBalanced("((()))", 0, 0));
    }
}