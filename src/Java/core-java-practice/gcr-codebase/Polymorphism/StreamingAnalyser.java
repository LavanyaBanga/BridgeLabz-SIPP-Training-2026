class PlatformSubscription {
    String subscriberName;
    String subscriptionId;

    PlatformSubscription(String subscriberName, String subscriptionId) {
        this.subscriberName = subscriberName;
        this.subscriptionId = subscriptionId;
    }

    double calculateMonthlyCharge() {
        return 0;
    }

    void displayDetails() {
        System.out.println(subscriptionId + " - " + subscriberName + " - Charge: " + calculateMonthlyCharge());
    }
}

class BasicPlan extends PlatformSubscription {
    BasicPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    double calculateMonthlyCharge() {
        return 199;
    }
}

class PremiumPlan extends PlatformSubscription {
    PremiumPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    double calculateMonthlyCharge() {
        return 499;
    }
}

class FamilyPlan extends PlatformSubscription {
    FamilyPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    double calculateMonthlyCharge() {
        return 799;
    }
}

public class StreamingSubscriptionAnalyzer {

    static void searchById(PlatformSubscription[] subscriptions, String id) {
        for (PlatformSubscription s : subscriptions) {
            if (s.subscriptionId.equals(id)) {
                System.out.println("Subscription Found:");
                s.displayDetails();
                return;
            }
        }
        System.out.println("Subscription not found.");
    }

    static void displayByStartingLetter(PlatformSubscription[] subscriptions, char ch) {
        for (PlatformSubscription s : subscriptions) {
            if (s.subscriberName.charAt(0) == ch) {
                s.displayDetails();
            }
        }
    }

    static double calculateTotalRevenue(PlatformSubscription[] subscriptions) {
        double total = 0;
        for (PlatformSubscription s : subscriptions) {
            total += s.calculateMonthlyCharge();
        }
        return total;
    }

    public static void main(String[] args) {
        PlatformSubscription[] subscriptions = {
                new BasicPlan("Lavanya", "S101"),
                new PremiumPlan("Riya", "S102"),
                new FamilyPlan("Aman", "S103")
        };

        PlatformSubscription expensive = subscriptions[0];

        for (PlatformSubscription s : subscriptions) {
            s.displayDetails();

            if (s.calculateMonthlyCharge() > expensive.calculateMonthlyCharge()) {
                expensive = s;
            }
        }

        System.out.println("Total Monthly Revenue: " + calculateTotalRevenue(subscriptions));

        System.out.println("Most Expensive Subscription:");
        expensive.displayDetails();

        searchById(subscriptions, "S102");

        System.out.println("Subscribers starting with L:");
        displayByStartingLetter(subscriptions, 'L');
    }
}
