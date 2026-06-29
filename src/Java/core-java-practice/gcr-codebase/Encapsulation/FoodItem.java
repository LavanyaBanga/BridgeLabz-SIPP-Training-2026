abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    abstract double calculateTotalPrice();

    void displayItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}

class VegItem extends FoodItem {
    VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

class NonVegItem extends FoodItem {
    double serviceCharge = 50;

    NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + serviceCharge;
    }
}

class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        VegItem v = new VegItem("Paneer Roll", 120, 2);
        NonVegItem n = new NonVegItem("Chicken Biryani", 250, 2);

        v.displayItemDetails();
        System.out.println("Total Price: " + v.calculateTotalPrice());

        System.out.println();

        n.displayItemDetails();
        System.out.println("Total Price: " + n.calculateTotalPrice());
    }
}