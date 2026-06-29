
class Order {
    protected int orderId;
    protected String orderDate;

    public Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order Placed";
    }
}

class ShippedOrder extends Order {
    protected String trackingNumber;

    public ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    public String getOrderStatus() {
        return "Order Shipped";
    }
}

class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    public DeliveredOrder(int orderId, String orderDate,
                          String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    public String getOrderStatus() {
        return "Order Delivered";
    }
    public void displayDetails() {
        System.out.println("Order ID       : " + orderId);
        System.out.println("Order Date     : " + orderDate);
        System.out.println("Tracking No.   : " + trackingNumber);
        System.out.println("Delivery Date  : " + deliveryDate);
        System.out.println("Status         : " + getOrderStatus());
    }
}

public class Main {
    public static void main(String[] args) {

        Order order = new Order(101, "25-Jun-2026");

        ShippedOrder shipped = new ShippedOrder(
                102,
                "26-Jun-2026",
                "TRK12345"
        );

        DeliveredOrder delivered = new DeliveredOrder(
                103,
                "27-Jun-2026",
                "TRK67890",
                "29-Jun-2026"
        );

        System.out.println("Order Status: " + order.getOrderStatus());

        System.out.println("\nShipped Order Status: " +
                shipped.getOrderStatus());

        System.out.println("\nDelivered Order Details:");
        delivered.displayDetails();
    }
}=
