public class Subsets {

    public static void generate(int[] arr,
                                int index,
                                String ans) {

        if (index == arr.length) {
            System.out.println("[" + ans + "]");
            return;
        }

        generate(arr, index + 1, ans);

        if (ans.length() == 0) {
            generate(arr, index + 1,
                    arr[index] + "");
        } else {
            generate(arr, index + 1,
                    ans + "," + arr[index]);
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 2};

        generate(arr, 0, "");
    }
}