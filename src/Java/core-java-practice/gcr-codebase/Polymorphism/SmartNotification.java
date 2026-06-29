class Notification {
    String recipientName;
    String message;

    Notification(String recipientName, String message) {
        this.recipientName = recipientName;
        this.message = message;
    }

    void sendNotification() {
        System.out.println("Sending notification...");
    }
}

class EmailNotification extends Notification {
    EmailNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    void sendNotification() {
        System.out.println("Email sent to " + recipientName + ": " + message);
    }
}

class SMSNotification extends Notification {
    SMSNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    void sendNotification() {
        System.out.println("SMS sent to " + recipientName + ": " + message);
    }
}

class PushNotification extends Notification {
    PushNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    void sendNotification() {
        System.out.println("Push Notification sent to " + recipientName + ": " + message);
    }
}

public class SmartNotificationSystem {
    public static void main(String[] args) {
        Notification[] notifications = {
                new EmailNotification("Lavanya", "Your order is confirmed."),
                new SMSNotification("Riya", "Your OTP is 1234."),
                new PushNotification("Aman", "You have a new message.")
        };

        for (Notification n : notifications) {
            n.sendNotification();
        }
    }
}
