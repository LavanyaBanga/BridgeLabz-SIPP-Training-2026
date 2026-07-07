public class TrainManagementSystem {

    static class Coach {
        int data;
        Coach next;

        Coach(int data) {
            this.data = data;
        }
    }

    Coach head;

    // 1. Add coach at end
    void addCoach(int data) {
        Coach newCoach = new Coach(data);

        if (head == null) {
            head = newCoach;
            return;
        }

        Coach temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newCoach;
    }

    // 2. Remove coach by value
    void removeCoach(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Coach temp = head;

        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // 3. Reverse entire train
    void reverseTrain() {
        Coach prev = null;
        Coach curr = head;

        while (curr != null) {
            Coach next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    // 4. Detect circular route / cycle
    boolean hasCycle() {
        Coach slow = head;
        Coach fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // 5. Find middle coach
    Coach findMiddle() {
        Coach slow = head;
        Coach fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // 6. Merge two sorted train schedules
    static Coach mergeSorted(Coach h1, Coach h2) {
        Coach dummy = new Coach(-1);
        Coach temp = dummy;

        while (h1 != null && h2 != null) {
            if (h1.data <= h2.data) {
                temp.next = h1;
                h1 = h1.next;
            } else {
                temp.next = h2;
                h2 = h2.next;
            }

            temp = temp.next;
        }

        if (h1 != null) temp.next = h1;
        if (h2 != null) temp.next = h2;

        return dummy.next;
    }

    // Print train
    void printTrain() {
        Coach temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        TrainManagementSystem train = new TrainManagementSystem();

        train.addCoach(10);
        train.addCoach(20);
        train.addCoach(30);
        train.addCoach(40);
        train.addCoach(50);

        System.out.println("Original Train:");
        train.printTrain();

        train.removeCoach(30);

        System.out.println("After Removing Coach 30:");
        train.printTrain();

        train.reverseTrain();

        System.out.println("After Reversing Train:");
        train.printTrain();

        Coach middle = train.findMiddle();

        System.out.println("Middle Coach: " + middle.data);

        System.out.println("Cycle Present: " + train.hasCycle());

        TrainManagementSystem t1 = new TrainManagementSystem();
        t1.addCoach(10);
        t1.addCoach(30);
        t1.addCoach(50);

        TrainManagementSystem t2 = new TrainManagementSystem();
        t2.addCoach(20);
        t2.addCoach(40);
        t2.addCoach(60);

        Coach mergedHead = mergeSorted(t1.head, t2.head);

        System.out.println("Merged Sorted Train Schedule:");
        Coach temp = mergedHead;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}
