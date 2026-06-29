class Book {
    protected String title;
    protected int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayInfo() {
        System.out.println("Book Title       : " + title);
        System.out.println("Publication Year : " + publicationYear);
    }
}
class Author extends Book {
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name      : " + name);
        System.out.println("Author Bio       : " + bio);
    }
}

public class Main {
    public static void main(String[] args) {

        Author author = new Author(
                "Java Programming",
                2024,
                "James Gosling",
                "Creator of the Java programming language."
        );

        author.displayInfo();
    }
}
=======
//
//class EducationCourse {
//    protected String courseName;
//    protected int duration; // in hours
//
//    public EducationCourse(String courseName, int duration) {
//        this.courseName = courseName;
//        this.duration = duration;
//    }
//
//    public void displayInfo() {
//        System.out.println("Course Name : " + courseName);
//        System.out.println("Duration    : " + duration + " hours");
//    }
//}
//
//class OnlineCourse extends EducationCourse {
//    protected String platform;
//    protected boolean isRecorded;
//
//    public OnlineCourse(String courseName, int duration,
//                        String platform, boolean isRecorded) {
//        super(courseName, duration);
//        this.platform = platform;
//        this.isRecorded = isRecorded;
//    }
//
//    @Override
//    public void displayInfo() {
//        super.displayInfo();
//        System.out.println("Platform    : " + platform);
//        System.out.println("Recorded    : " + (isRecorded ? "Yes" : "No"));
//    }
//}
//
//class PaidOnlineCourse extends OnlineCourse {
//    private double fee;
//    private double discount;
//
//    public PaidOnlineCourse(String courseName, int duration,
//                            String platform, boolean isRecorded,
//                            double fee, double discount) {
//        super(courseName, duration, platform, isRecorded);
//        this.fee = fee;
//        this.discount = discount;
//    }
//
//    @Override
//    public void displayInfo() {
//        super.displayInfo();
//        System.out.println("Course Fee  : ₹" + fee);
//        System.out.println("Discount    : " + discount + "%");
//
//        double finalFee = fee - (fee * discount / 100);
//        System.out.println("Final Fee   : ₹" + finalFee);
//    }
//}
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        PaidOnlineCourse course = new PaidOnlineCourse(
//                "Java Programming",
//                60,
//                "Udemy",
//                true,
//                5000,
//                20
//        );
//
//        course.displayInfo();
//    }
//}
>>>>>>> 7f8a402 (this is java)
