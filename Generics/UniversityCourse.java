import java.util.*;

abstract class CourseType {
    String type;

    CourseType(String type) {
        this.type = type;
    }

    abstract void evaluate();
}

class ExamCourse extends CourseType {
    ExamCourse() {
        super("Exam Based");
    }

    void evaluate() {
        System.out.println("Evaluation through exams.");
    }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse() {
        super("Assignment Based");
    }

    void evaluate() {
        System.out.println("Evaluation through assignments.");
    }
}

class ResearchCourse extends CourseType {
    ResearchCourse() {
        super("Research Based");
    }

    void evaluate() {
        System.out.println("Evaluation through research work.");
    }
}

class Course<T extends CourseType> {
    String courseName;
    T courseType;

    Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    void display() {
        System.out.println(courseName + " - " + courseType.type);
        courseType.evaluate();
    }
}

public class Main {
    static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course.type);
            course.evaluate();
        }
    }

    public static void main(String[] args) {
        Course<ExamCourse> java = new Course<>("Java", new ExamCourse());
        Course<ResearchCourse> ai = new Course<>("AI Research", new ResearchCourse());

        java.display();
        ai.display();

        List<CourseType> list = new ArrayList<>();
        list.add(new ExamCourse());
        list.add(new AssignmentCourse());
        list.add(new ResearchCourse());

        displayCourses(list);
    }
}=
