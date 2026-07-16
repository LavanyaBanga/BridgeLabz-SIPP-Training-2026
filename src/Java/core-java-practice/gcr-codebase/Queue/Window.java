import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    static int[] maxThroughputWindow(
            int[] readings,
            int windowSize
    ) {

        if (readings == null
                || readings.length == 0
                || windowSize <= 0
                || windowSize > readings.length) {

            return new int[0];
        }

        int totalWindows =
                readings.length - windowSize + 1;

        int[] result = new int[totalWindows];

        // Stores indices in decreasing order of values
        Deque<Integer> deque = new ArrayDeque<>();

        for (int currentIndex = 0;
             currentIndex < readings.length;
             currentIndex++) {

            /*
             Remove indices that are outside
             the current window.
            */
            while (!deque.isEmpty()
                    && deque.peekFirst()
                    <= currentIndex - windowSize) {

                deque.pollFirst();
            }

            /*
             Remove smaller or equal readings from the back.

             They cannot become maximum while the current
             larger reading remains inside the window.
            */
            while (!deque.isEmpty()
                    && readings[deque.peekLast()]
                    <= readings[currentIndex]) {

                deque.pollLast();
            }

            deque.offerLast(currentIndex);

            /*
             Window becomes complete when:
             currentIndex >= windowSize - 1
            */
            if (currentIndex >= windowSize - 1) {

                int resultIndex =
                        currentIndex - windowSize + 1;

                result[resultIndex] =
                        readings[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] readings = {
                1, 3, -1, -3, 5, 3, 6, 7
        };

        int windowSize = 3;

        int[] result =
                maxThroughputWindow(readings, windowSize);

        System.out.println(
                "Readings: "
                        + Arrays.toString(readings)
        );

        System.out.println(
                "Window size: " + windowSize
        );

        System.out.println(
                "Maximums: "
                        + Arrays.toString(result)
        );
    }
}
