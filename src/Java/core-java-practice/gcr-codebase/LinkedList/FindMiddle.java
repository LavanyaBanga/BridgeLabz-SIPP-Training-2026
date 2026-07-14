public class FindMiddleServer {

    static class Node {
        int serverId;
        Node next;

        Node(int serverId) {
            this.serverId = serverId;
            this.next = null;
        }
    }

    static Node findMiddleServer(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static void printServers(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.serverId);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        System.out.println("Server chain:");
        printServers(head);

        Node middleServer = findMiddleServer(head);

        if (middleServer != null) {
            System.out.println(
                "Middle server: " + middleServer.serverId
            );
        }
    }
}
