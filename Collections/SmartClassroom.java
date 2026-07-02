import java.util.*;

public class SmartClassroomAttendanceTracker {
    HashMap<String, ArrayList<String>> attendance = new HashMap<>();

    void markAttendance(String subject, String studentName) {
        attendance.putIfAbsent(subject, new ArrayList<>());

        ArrayList<String> students = attendance.get(subject);

        if (students.contains(studentName)) {
            System.out.println(studentName + " already marked present in " + subject);
        } else {
            students.add(studentName);
            System.out.println(studentName + " marked present in " + subject);
        }
    }

    void displayAttendance() {
        System.out.println("\nAttendance Records:");

        for (String subject : attendance.keySet()) {
            ArrayList<String> students = attendance.get(subject);

            System.out.println("\nSubject: " + subject);
            for (String student : students) {
                System.out.println(student);
            }
            System.out.println("Total students present: " + students.size());
        }
    }

    public static void main(String[] args) {
        SmartClassroomAttendanceTracker tracker =
                new SmartClassroomAttendanceTracker();

        tracker.markAttendance("Java", "Lavanya");
        tracker.markAttendance("Java", "Aman");
        tracker.markAttendance("Java", "Lavanya");

        tracker.markAttendance("DBMS", "Riya");
        tracker.markAttendance("DBMS", "Aman");

        tracker.displayAttendance();
    }
}
