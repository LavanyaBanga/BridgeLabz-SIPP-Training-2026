import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {

    private Deque<Integer> mainStack;
    private Deque<Integer> minimumStack;

    public MinStack() {
        mainStack = new ArrayDeque<>();
        minimumStack = new ArrayDeque<>();
    }

    public void push(int value) {
        mainStack.push(value);

        if (minimumStack.isEmpty() || value <= minimumStack.peek()) {
            minimumStack.push(value);
        }
    }

    public void pop() {
        int removedValue = mainStack.pop();

        if (removedValue == minimumStack.peek()) {
            minimumStack.pop();
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minimumStack.peek();
    }
}
