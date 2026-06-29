class CartItem {

    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = 0;
    }

    void addItem(int qty) {
        quantity += qty;
    }

    void removeItem(int qty) {

        if (qty <= quantity)
            quantity -= qty;
        else
            System.out.println("Not enough quantity.");
    }

    void displayTotalCost() {

        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + (price * quantity));
    }

    public static void main(String[] args) {

        CartItem c = new CartItem("Shoes", 2500);

        c.addItem(3);

        c.removeItem(1);

        c.displayTotalCost();
    }
}