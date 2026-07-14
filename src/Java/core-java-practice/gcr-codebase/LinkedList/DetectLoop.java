public class DetectRedirectLoop {

    static class Node {
        String url;
        Node next;

        Node(String url) {
            this.url = url;
            this.next = null;
        }
    }

    static boolean hasRedirectLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Node first = new Node("URL-A");
        Node second = new Node("URL-B");
        Node third = new Node("URL-C");
        Node fourth = new Node("URL-D");

        first.next = second;
        second.next = third;
        third.next = fourth;

      
        fourth.next = second;

        boolean result = hasRedirectLoop(first);

        if (result) {
            System.out.println("Redirect loop detected.");
        } else {
            System.out.println("No redirect loop found.");
        }
    }
}
