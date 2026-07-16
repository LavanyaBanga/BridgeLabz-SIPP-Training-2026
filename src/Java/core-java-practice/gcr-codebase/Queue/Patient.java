import java.util.PriorityQueue;

public class Main {

    static class Patient {
        String name;
        int priority;
        int arrivalOrder;

        Patient(String name, int priority, int arrivalOrder) {
            this.name = name;
            this.priority = priority;
            this.arrivalOrder = arrivalOrder;
        }

        @Override
        public String toString() {
            return name + " (Priority: " + priority + ")";
        }
    }

    static class EmergencyRoom {
        private final PriorityQueue<Patient> triageQueue;
        private int nextArrivalOrder;

        EmergencyRoom() {
            nextArrivalOrder = 0;

            triageQueue = new PriorityQueue<>((patient1, patient2) -> {

                // Lower priority number comes first
                int priorityComparison =
                        Integer.compare(
                                patient1.priority,
                                patient2.priority
                        );

                if (priorityComparison != 0) {
                    return priorityComparison;
                }

                // Same priority: earlier patient comes first
                return Integer.compare(
                        patient1.arrivalOrder,
                        patient2.arrivalOrder
                );
            });
        }

        public void admitPatient(String name, int priority) {
            if (priority < 1 || priority > 5) {
                throw new IllegalArgumentException(
                        "Priority must be between 1 and 5"
                );
            }

            Patient patient = new Patient(
                    name,
                    priority,
                    nextArrivalOrder++
            );

            triageQueue.offer(patient);

            System.out.println("Admitted: " + patient);
        }

        public Patient callNextPatient() {
            if (triageQueue.isEmpty()) {
                throw new RuntimeException("No patients are waiting");
            }

            return triageQueue.poll();
        }

        public Patient peekMostUrgent() {
            return triageQueue.peek();
        }

        public boolean isEmpty() {
            return triageQueue.isEmpty();
        }
    }

    public static void main(String[] args) {

        EmergencyRoom emergencyRoom = new EmergencyRoom();

        emergencyRoom.admitPatient("Aman", 4);
        emergencyRoom.admitPatient("Riya", 2);
        emergencyRoom.admitPatient("Karan", 1);
        emergencyRoom.admitPatient("Meera", 2);

        System.out.println(
                "\nMost urgent patient: "
                        + emergencyRoom.peekMostUrgent()
        );

        System.out.println("\nTreatment order:");

        while (!emergencyRoom.isEmpty()) {
            System.out.println(
                    emergencyRoom.callNextPatient()
            );
        }
    }
}
