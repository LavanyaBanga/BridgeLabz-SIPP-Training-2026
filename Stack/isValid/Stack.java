import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char bracket : s.toCharArray()) {

            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                char openingBracket = stack.pop();

                if (bracket == ')' && openingBracket != '(') {
                    return false;
                }

                if (bracket == '}' && openingBracket != '{') {
                    return false;
                }

                if (bracket == ']' && openingBracket != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
