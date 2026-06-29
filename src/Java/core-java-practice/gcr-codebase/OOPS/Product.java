class Product {
    static double discount = 10;

    String productName;
    double price;
    int quantity;
    final int productID;

    Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    void displayDetails() {
        double total = price * quantity;
        double finalAmount = total - (total * discount / 100);

        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Amount: " + finalAmount);
    }

    public static void main(String[] args) {
        Product p1 = new Product(301, "Laptop", 50000, 1);

        Product.updateDiscount(15);

        if (p1 instanceof Product) {
            p1.displayDetails();
        }
    }
}