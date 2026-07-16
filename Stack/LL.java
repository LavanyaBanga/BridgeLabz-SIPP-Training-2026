public class Main {

    static class CallStack {

        // Stack ka ek node
        private static class Frame {
            String functionName;
            Frame next;

            Frame(String functionName) {
                this.functionName = functionName;
            }
        }

        private Frame top;

        // Function call ko stack mein add karna
        public void push(String functionName) {
            Frame newFrame = new Frame(functionName);

            // New node pehle current top ko point karega
            newFrame.next = top;

            // Ab new node top ban jayega
            top = newFrame;

            System.out.println(functionName + " called");
        }

        // Current function call ko remove karna
        public String pop() {
            if (isEmpty()) {
                throw new RuntimeException(
                    "No active function call to return from"
                );
            }

            String returnedFunction = top.functionName;

            // Top ko next node par shift kar diya
            top = top.next;

            return returnedFunction;
        }

        // Currently executing function dekhna
        public String peek() {
            if (isEmpty()) {
                throw new RuntimeException(
                    "No function is currently executing"
                );
            }

            return top.functionName;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Call stack is empty");
                return;
            }

            System.out.println("\nCurrent call stack:");

            Frame current = top;

            while (current != null) {
                System.out.println(current.functionName);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {

        CallStack callStack = new CallStack();

        callStack.push("main()");
        callStack.push("login()");
        callStack.push("validateUser()");
        callStack.push("checkPassword()");

        callStack.display();

        System.out.println(
            "\nCurrently executing: " + callStack.peek()
        );

        System.out.println(
            "Returned from: " + callStack.pop()
        );

        System.out.println(
            "Returned from: " + callStack.pop()
        );

        System.out.println(
            "\nCurrently executing: " + callStack.peek()
        );

        callStack.display();
    }
}
