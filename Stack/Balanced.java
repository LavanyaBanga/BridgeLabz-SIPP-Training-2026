import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static boolean isValidConfig(String brackets) {

        Deque<Character> stack = new ArrayDeque<>();

        for (char currentBracket : brackets.toCharArray()) {

            // Opening brackets ko stack mein push karo
            if (currentBracket == '(' ||
                currentBracket == '{' ||
                currentBracket == '[') {

                stack.push(currentBracket);
            }

            // Closing bracket: )
            else if (currentBracket == ')') {

                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }

            // Closing bracket: }
            else if (currentBracket == '}') {

                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }

            // Closing bracket: ]
            else if (currentBracket == ']') {

                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
        }

        // All opening brackets should be matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String config1 = "{[()]}";
        String config2 = "{[(])}";
        String config3 = "((()))";
        String config4 = "(()";

        System.out.println(config1 + " -> " + isValidConfig(config1));
        System.out.println(config2 + " -> " + isValidConfig(config2));
        System.out.println(config3 + " -> " + isValidConfig(config3));
        System.out.println(config4 + " -> " + isValidConfig(config4));
    }
}
