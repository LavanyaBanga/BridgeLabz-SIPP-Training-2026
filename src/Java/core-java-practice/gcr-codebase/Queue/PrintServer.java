import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static class PrintServer {
        private final Deque<Integer> printQueue;

        PrintServer() {
            printQueue = new ArrayDeque<>();
        }

        // Normal job: queue ke end mein add hoga
        public void submitJob(int jobId) {
            printQueue.addLast(jobId);

            System.out.println(
                    "Normal job submitted: " + jobId
            );
        }

        // Urgent job: queue ke front mein add hoga
        public void submitUrgentJob(int jobId) {
            printQueue.addFirst(jobId);

            System.out.println(
                    "Urgent job submitted: " + jobId
            );
        }

        // Printer front wala job process karega
        public int printNextJob() {
            if (printQueue.isEmpty()) {
                throw new RuntimeException("No print jobs available");
            }

            return printQueue.removeFirst();
        }

        public Integer peekNextJob() {
            return printQueue.peekFirst();
        }

        public boolean isEmpty() {
            return printQueue.isEmpty();
        }

        public void display() {
            System.out.println("Print queue: " + printQueue);
        }
    }

    public static void main(String[] args) {

        PrintServer server = new PrintServer();

        server.submitJob(101);
        server.submitJob(102);
        server.submitJob(103);

        server.display();

        server.submitUrgentJob(999);

        server.display();

        System.out.println(
                "Printing job: " + server.printNextJob()
        );

        System.out.println(
                "Printing job: " + server.printNextJob()
        );

        server.display();
    }
}
