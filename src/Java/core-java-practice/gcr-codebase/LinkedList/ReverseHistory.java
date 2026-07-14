public class ReverseBrowserHistory {

    static class Node {
        int pageId;
        Node next;

        Node(int pageId) {
            this.pageId = pageId;
            this.next = null;
        }
    }

    static Node reverseHistory(Node head) {
        Node previous = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;

            current.next = previous;

            previous = current;
            current = nextNode;
        }

        return previous;
    }

    static void printHistory(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.pageId);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(104);
        head.next = new Node(103);
        head.next.next = new Node(102);
        head.next.next.next = new Node(101);

        System.out.println("Original browser history:");
        printHistory(head);

        head = reverseHistory(head);

        System.out.println("Reversed browser history:");
        printHistory(head);
    }
}
