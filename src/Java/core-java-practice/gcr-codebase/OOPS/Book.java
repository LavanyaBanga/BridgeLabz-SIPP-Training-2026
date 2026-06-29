class Book {
    static String libraryName = "City Library";

    String title;
    String author;
    final String isbn;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }

    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "James Gosling", "ISBN101");

        Book.displayLibraryName();

        if (b1 instanceof Book) {
            b1.displayDetails();
        }
    }
}