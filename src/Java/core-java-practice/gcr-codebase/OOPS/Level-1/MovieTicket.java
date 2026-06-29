class MovieTicket {

    String movieName;
    String seatNumber;
    double price;

    MovieTicket(String movieName) {
        this.movieName = movieName;
    }

    void bookTicket(String seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Ticket Price: " + price);
    }

    public static void main(String[] args) {

        MovieTicket ticket = new MovieTicket("Avengers");

        ticket.bookTicket("A10", 300);

        ticket.displayDetails();
    }
}