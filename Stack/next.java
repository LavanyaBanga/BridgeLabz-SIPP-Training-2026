import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    static int[] nextBusierDay(int[] visitors) {
        int n = visitors.length;

        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        // Stack mein unresolved days ke indices store honge
        Deque<Integer> stack = new ArrayDeque<>();

        for (int currentDay = 0; currentDay < n; currentDay++) {

            /*
             Current visitors agar stack ke top wale day se greater hain,
             to current day us day ka Next Greater Element hai.
            */
            while (!stack.isEmpty()
                    && visitors[currentDay] > visitors[stack.peek()]) {

                int previousDay = stack.pop();
                answer[previousDay] = visitors[currentDay];
            }

            stack.push(currentDay);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] visitors = {40, 50, 30, 60, 45};

        int[] result = nextBusierDay(visitors);

        System.out.println(
                "Visitor counts: " + Arrays.toString(visitors)
        );

        System.out.println(
                "Next greater:   " + Arrays.toString(result)
        );
    }
}
