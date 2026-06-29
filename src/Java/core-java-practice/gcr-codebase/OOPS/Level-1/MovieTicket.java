class MovieTicket{

    int itemCode;
    String itemName;
    double price;

    MovieTicket(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
    }

    void totalCost(int quantity) {
        System.out.println("Total Cost = " + (price * quantity));
    }

    public static void main(String[] args) {

        MovieTicket i = new MovieTicket.(1001, "Laptop", 55000);

        i.displayDetails();
        i.totalCost(2);
    }
}