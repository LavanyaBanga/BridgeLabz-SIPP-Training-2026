import java.util.*;

public class StackBasedProblems {

    // 1. Balanced Brackets Validator
    static boolean isBalanced(String code) {
        Stack<Character> st = new Stack<>();

        for (char ch : code.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }

            else if (ch == ')' || ch == '}' || ch == ']') {

                if (st.isEmpty()) return false;

                char top = st.pop();

                if (ch == ')' && top != '(') return false;
                if (ch == '}' && top != '{') return false;
                if (ch == ']' && top != '[') return false;
            }
        }

        return st.isEmpty();
    }

    // 2. Next Greater Price for each day
    // Monotonic stack: O(n)
    static int[] nextGreaterPrice(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];

        Arrays.fill(ans, -1);

        Stack<Integer> st = new Stack<>(); 
        // stack stores indexes

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && prices[i] > prices[st.peek()]) {
                int idx = st.pop();
                ans[idx] = prices[i];
            }

            st.push(i);
        }

        return ans;
    }

    // 3. Stock Span
    // Previous greater element logic: O(n)
    static int[] stockSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];

        Stack<Integer> st = new Stack<>();
        // stack stores indexes of previous greater elements

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && prices[st.peek()] <= prices[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - st.peek();
            }

            st.push(i);
        }

        return span;
    }

    public static void main(String[] args) {

        String code1 = "{[()]}";
        String code2 = "{[(])}";

        System.out.println("Code 1 Balanced: " + isBalanced(code1));
        System.out.println("Code 2 Balanced: " + isBalanced(code2));

        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        System.out.println("Next Greater Prices:");
        System.out.println(Arrays.toString(nextGreaterPrice(prices)));

        System.out.println("Stock Span:");
        System.out.println(Arrays.toString(stockSpan(prices)));
    }
}
