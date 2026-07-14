public class RemoveCompletedTask {

    static class Node {
        int taskId;
        Node next;

        Node(int taskId) {
            this.taskId = taskId;
            this.next = null;
        }
    }

  
    static Node removeTask(Node head, int completedTaskId) {

        
        if (head == null) {
            return null;
        }

      
        if (head.taskId == completedTaskId) {
            return head.next;
        }

        Node previous = head;
        Node current = head.next;

        // Task ko search karo
        while (current != null &&
               current.taskId != completedTaskId) {

            previous = current;
            current = current.next;
        }

      
        if (current != null) {
            previous.next = current.next;
        } else {
            System.out.println("Task not found.");
        }

        return head;
    }

    static void printTasks(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.taskId);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Task queue: 101 -> 102 -> 103 -> 104
        Node head = new Node(101);
        head.next = new Node(102);
        head.next.next = new Node(103);
        head.next.next.next = new Node(104);

        System.out.println("Original task queue:");
        printTasks(head);

    
        head = removeTask(head, 103);

        System.out.println("After removing completed task 103:");
        printTasks(head);

        
        head = removeTask(head, 101);

        System.out.println("After removing first task 101:");
        printTasks(head);
    }
}
