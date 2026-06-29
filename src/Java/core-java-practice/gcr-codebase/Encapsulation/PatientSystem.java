public abstract class PatientSystem {

    private int patientId;
    private String name;
    private int age;

    public PatientSystem(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Abstract Method
    abstract double calculateBill();

    // Concrete Method
    public void displayPatientDetails() {
        System.out.println("Patient ID : " + patientId);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
    }

    public static void main(String[] args) {

        InPatient ip = new InPatient(101, "Lavanya", 20, 3000, 5000);
        OutPatient op = new OutPatient(102, "Riya", 21, 700, 1500);

        System.out.println("----- In Patient -----");
        ip.displayPatientDetails();
        System.out.println("Total Bill : " + ip.calculateBill());

        System.out.println();

        System.out.println("----- Out Patient -----");
        op.displayPatientDetails();
        System.out.println("Total Bill : " + op.calculateBill());
    }
}

class InPatient extends PatientSystem {

    private double roomCharges;
    private double treatmentCharges;

    public InPatient(int patientId, String name, int age,
                     double roomCharges, double treatmentCharges) {

        super(patientId, name, age);
        this.roomCharges = roomCharges;
        this.treatmentCharges = treatmentCharges;
    }

    @Override
    double calculateBill() {
        return roomCharges + treatmentCharges;
    }
}

class OutPatient extends PatientSystem {

    private double consultationFees;
    private double treatmentCharges;

    public OutPatient(int patientId, String name, int age,
                      double consultationFees, double treatmentCharges) {

        super(patientId, name, age);
        this.consultationFees = consultationFees;
        this.treatmentCharges = treatmentCharges;
    }

    @Override
    double calculateBill() {
        return consultationFees + treatmentCharges;
    }
}