abstract class LibraryItem {

    private int itemId;
    private String title;
    private String author;

    LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    abstract int getLoanDuration();

    void displayItemDetails() {
        System.out.println("Item ID : " + itemId);
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
    }
}

class LibraryBook extends LibraryItem {

    LibraryBook(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    int getLoanDuration() {
        return 14;
    }
}

class LibraryMagazine extends LibraryItem {

    LibraryMagazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    int getLoanDuration() {
        return 7;
    }
}

class LibraryDVD extends LibraryItem {

    LibraryDVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    int getLoanDuration() {
        return 3;
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) {

        LibraryBook book = new LibraryBook(101, "Java Programming", "James Gosling");

        LibraryMagazine magazine = new LibraryMagazine(102, "Tech Today", "John");

        LibraryDVD dvd = new LibraryDVD(103, "Java Tutorial", "Oracle");

        System.out.println("----- Book -----");
        book.displayItemDetails();
        System.out.println("Loan Duration: " + book.getLoanDuration() + " days");

        System.out.println();

        System.out.println("----- Magazine -----");
        magazine.displayItemDetails();
        System.out.println("Loan Duration: " + magazine.getLoanDuration() + " days");

        System.out.println();

        System.out.println("----- DVD -----");
        dvd.displayItemDetails();
        System.out.println("Loan Duration: " + dvd.getLoanDuration() + " days");
    }
}