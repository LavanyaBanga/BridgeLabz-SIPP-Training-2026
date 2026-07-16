import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public int[] dailyTemperatures(int[] temperatures) {

        int[] answer = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int currentDay = 0;
             currentDay < temperatures.length;
             currentDay++) {

            while (!stack.isEmpty()
                    && temperatures[currentDay]
                    > temperatures[stack.peek()]) {

                int previousDay = stack.pop();

                answer[previousDay] =
                        currentDay - previousDay;
            }

            stack.push(currentDay);
        }

        return answer;
    }
}
