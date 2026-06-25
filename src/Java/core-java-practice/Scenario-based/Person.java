class Person {

    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name +
               ", Age: " + age;
    }
}

class Student extends Person {

    protected final String studentId;
    protected double gpa;

    public Student(String name, int age,
                   String studentId, double gpa) {

        super(name, age); // Constructor Chaining

        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Student ID: " + studentId +
               ", GPA: " + gpa;
    }
}

class GradStudent extends Student {

    private String thesis;

    public GradStudent(String name, int age,
                       String studentId,
                       double gpa,
                       String thesis) {

        super(name, age, studentId, gpa); // Constructor Chaining

        this.thesis = thesis;
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Thesis: " + thesis;
    }
}

public class UniversitySystem {

    public static void main(String[] args) {

        GradStudent gs =
                new GradStudent(
                        "Lavanya",
                        20,
                        "GLA123",
                        9.2,
                        "AI in Healthcare"
                );

        System.out.println(gs);

        // Demonstrating IS-A Relationship

        Student s = gs;   // GradStudent IS-A Student
        Person p = gs;    // GradStudent IS-A Person

        System.out.println("\nUsing Student Reference:");
        System.out.println(s);

        System.out.println("\nUsing Person Reference:");
        System.out.println(p);
    }
}
