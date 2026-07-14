public class InsertTrackAfterCurrent {
    static class Node {
        int trackId;
        Node next;

        Node(int trackId) {
            this.trackId = trackId;
            this.next = null;
        }
    }

 
    static void insertAfter(Node current, int newTrackId) {

        if (current == null) {
            System.out.println("Current track cannot be null.");
            return;
        }

        Node newTrack = new Node(newTrackId);

       
        newTrack.next = current.next;
        current.next = newTrack;
    }

    // Playlist print karne ke liye
    static void printPlaylist(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.trackId);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Playlist: 101 -> 102 -> 103 -> 104
        Node head = new Node(101);
        head.next = new Node(102);
        head.next.next = new Node(103);
        head.next.next.next = new Node(104);

        System.out.println("Original playlist:");
        printPlaylist(head);

        
        Node currentTrack = head.next;

       
        insertAfter(currentTrack, 105);

        System.out.println("Playlist after inserting track 105:");
        printPlaylist(head);
    }
}
