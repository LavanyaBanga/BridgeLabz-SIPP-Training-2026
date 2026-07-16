import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    static int[] loadSpan(int[] load) {
        int n = load.length;

        int[] span = new int[n];

        // Stack mein greater load readings ke indices rahenge
        Deque<Integer> stack = new ArrayDeque<>();

        for (int currentIndex = 0; currentIndex < n; currentIndex++) {

            /*
             Current load se smaller ya equal readings ko remove karo,
             kyunki woh span ko stop nahi kar sakti.
            */
            while (!stack.isEmpty()
                    && load[stack.peek()] <= load[currentIndex]) {

                stack.pop();
            }

            /*
             Stack empty:
             Current load sabhi previous readings se greater/equal hai.

             Stack not empty:
             Top par previous greater reading ka index hai.
            */
            if (stack.isEmpty()) {
                span[currentIndex] = currentIndex + 1;
            } else {
                span[currentIndex] =
                        currentIndex - stack.peek();
            }

            stack.push(currentIndex);
        }

        return span;
    }

    public static void main(String[] args) {

        int[] load = {100, 80, 60, 70, 60, 75, 85};

        int[] result = loadSpan(load);

        System.out.println(
                "Server load: " + Arrays.toString(load)
        );

        System.out.println(
                "Load span:   " + Arrays.toString(result)
        );
    }
}
