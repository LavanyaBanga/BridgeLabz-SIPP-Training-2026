import java.util.PriorityQueue;

class Patient {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}

public class ERTriage {

 
    PriorityQueue<Patient> triageQueue =
            new PriorityQueue<>((a, b) -> b.severity - a.severity);

  
    public void addPatient(Patient p) {
        triageQueue.offer(p);   
    }

  
    public Patient treatNext() {
        return triageQueue.poll();  
    }

    public static void main(String[] args) {

        ERTriage er = new ERTriage();

        er.addPatient(new Patient("Alice", 4));
        er.addPatient(new Patient("Bob", 9));
        er.addPatient(new Patient("Charlie", 6));
        er.addPatient(new Patient("David", 8));

        while (!er.triageQueue.isEmpty()) {
            Patient p = er.treatNext();
            System.out.println(p.name + " (Severity: " + p.severity + ")");
        }
    }
}
