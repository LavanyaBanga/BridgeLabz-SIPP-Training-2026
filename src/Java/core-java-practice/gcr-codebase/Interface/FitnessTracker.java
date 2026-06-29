interface Trackable {
    void logActivity();

    default void resetData() {
        System.out.println("Fitness data reset.");
    }
}

interface Reportable {
    void generateReport();
}

interface Notifiable {
    void sendAlert();
}

public class FitnessTracker implements Trackable, Reportable, Notifiable {

    @Override
    public void logActivity() {
        System.out.println("Activity Logged.");
    }

    @Override
    public void generateReport() {
        System.out.println("Report Generated.");
    }

    @Override
    public void sendAlert() {
        System.out.println("Alert Sent.");
    }

    public static void main(String[] args) {

        FitnessTracker device = new FitnessTracker();

        device.logActivity();
        device.generateReport();
        device.sendAlert();
        device.resetData();
    }
}