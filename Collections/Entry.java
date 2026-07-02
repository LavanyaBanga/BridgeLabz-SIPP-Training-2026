import java.util.*;

public class EventEntryVerificationSystem {
    HashSet<String> participants = new HashSet<>();

    void registerParticipant(String email) {
        if (participants.add(email)) {
            System.out.println("Registration successful: " + email);
        } else {
            System.out.println("Duplicate registration rejected: " + email);
        }
    }

    void displayParticipants() {
        System.out.println("\nUnique Registered Participants:");
        for (String email : participants) {
            System.out.println(email);
        }

        System.out.println("Total attendees: " + participants.size());
    }

    public static void main(String[] args) {
        EventEntryVerificationSystem event = new EventEntryVerificationSystem();

        event.registerParticipant("lavanya@gmail.com");
        event.registerParticipant("aman@gmail.com");
        event.registerParticipant("riya@gmail.com");
        event.registerParticipant("lavanya@gmail.com");

        event.displayParticipants();
    }
}
