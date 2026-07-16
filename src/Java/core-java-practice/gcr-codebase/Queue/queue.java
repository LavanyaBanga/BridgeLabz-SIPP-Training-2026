public class Main {

    static class PacketBuffer {
        private final int[] packets;
        private int front;
        private int count;

        PacketBuffer(int capacity) {
            if (capacity <= 0) {
                throw new IllegalArgumentException(
                        "Capacity must be greater than zero"
                );
            }

            packets = new int[capacity];
            front = 0;
            count = 0;
        }

        public boolean enqueue(int packetId) {
            if (isFull()) {
                System.out.println(
                        "Buffer full. Packet " + packetId + " rejected."
                );
                return false;
            }

            int rearIndex = (front + count) % packets.length;
            packets[rearIndex] = packetId;
            count++;

            return true;
        }

        public int dequeue() {
            if (isEmpty()) {
                throw new RuntimeException("Packet buffer is empty");
            }

            int removedPacket = packets[front];

            front = (front + 1) % packets.length;
            count--;

            return removedPacket;
        }

        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("Packet buffer is empty");
            }

            return packets[front];
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return count == packets.length;
        }

        public int size() {
            return count;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Buffer is empty");
                return;
            }

            System.out.print("Packets: ");

            for (int i = 0; i < count; i++) {
                int index = (front + i) % packets.length;
                System.out.print(packets[index] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        PacketBuffer buffer = new PacketBuffer(3);

        buffer.enqueue(101);
        buffer.enqueue(102);
        buffer.enqueue(103);

        buffer.display();

        // Buffer is full
        buffer.enqueue(104);

        System.out.println("Processed packet: " + buffer.dequeue());
        System.out.println("Processed packet: " + buffer.dequeue());

        // Freed positions will be reused
        buffer.enqueue(104);
        buffer.enqueue(105);

        buffer.display();

        System.out.println("Next packet: " + buffer.peek());
    }
}
