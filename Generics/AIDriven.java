import java.util.*;

abstract class JobRole {
    String roleName;

    JobRole(String roleName) {
        this.roleName = roleName;
    }

    abstract void screenResume();
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer() {
        super("Software Engineer");
    }

    void screenResume() {
        System.out.println("Checking DSA, Java, OOPs, DBMS, Projects.");
    }
}

class DataScientist extends JobRole {
    DataScientist() {
        super("Data Scientist");
    }

    void screenResume() {
        System.out.println("Checking Python, ML, Statistics, Data Analysis.");
    }
}

class ProductManager extends JobRole {
    ProductManager() {
        super("Product Manager");
    }

    void screenResume() {
        System.out.println("Checking leadership, communication, product thinking.");
    }
}

class Resume<T extends JobRole> {
    String candidateName;
    T jobRole;

    Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    void processResume() {
        System.out.println("Candidate: " + candidateName);
        System.out.println("Applied Role: " + jobRole.roleName);
        jobRole.screenResume();
    }
}

public class Main {
    static void screenMultipleRoles(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            System.out.println("Screening for: " + role.roleName);
            role.screenResume();
        }
    }

    public static void main(String[] args) {
        Resume<SoftwareEngineer> r1 = new Resume<>("Lavanya", new SoftwareEngineer());
        Resume<DataScientist> r2 = new Resume<>("Aman", new DataScientist());

        r1.processResume();
        r2.processResume();

        List<JobRole> roles = new ArrayList<>();
        roles.add(new SoftwareEngineer());
        roles.add(new DataScientist());
        roles.add(new ProductManager());

        screenMultipleRoles(roles);
    }
}
