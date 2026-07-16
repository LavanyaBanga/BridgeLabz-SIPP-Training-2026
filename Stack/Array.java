
public class Main {

    static class UndoBuffer {
        private String[] edits;
        private int top;

        public UndoBuffer(int maximumDepth) {
            edits = new String[maximumDepth];
            top = -1;
        }

        // Add a new edit to the stack
        public boolean push(String edit) {
            if (isFull()) {
                System.out.println("Undo buffer is full. Cannot add: " + edit);
                return false;
            }

            top++;
            edits[top] = edit;
            return true;
        }

        // Remove and return the latest edit
        public String pop() {
            if (isEmpty()) {
                throw new RuntimeException("Nothing to undo");
            }

            String latestEdit = edits[top];
            edits[top] = null;
            top--;

            return latestEdit;
        }

        // Return the latest edit without removing it
        public String peek() {
            if (isEmpty()) {
                throw new RuntimeException("No edit available");
            }

            return edits[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == edits.length - 1;
        }

        public int size() {
            return top + 1;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Undo buffer is empty");
                return;
            }

            System.out.println("Edits in undo buffer:");

            for (int i = top; i >= 0; i--) {
                System.out.println(edits[i]);
            }
        }
    }

    public static void main(String[] args) {

        UndoBuffer undoBuffer = new UndoBuffer(3);

        undoBuffer.push("Typed: Hello");
        undoBuffer.push("Changed font size");
        undoBuffer.push("Added image");

        // Capacity is only 3, so this edit will be rejected
        undoBuffer.push("Changed background color");

        undoBuffer.display();

        System.out.println("\nLatest edit: " + undoBuffer.peek());

        System.out.println("Undoing: " + undoBuffer.pop());
        System.out.println("Undoing: " + undoBuffer.pop());

        System.out.println("\nRemaining edits:");
        undoBuffer.display();

        System.out.println("\nCurrent stack size: " + undoBuffer.size());
    }
}
