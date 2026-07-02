interface Trackable {
    void logActivity();

    default void resetData() {
        System.out.println("Activity data has been reset.");
    }
}

interface Reportable {
    void generateReport();
}

interface Notifiable {
    void sendAlert();
}

class FitnessDevice implements Trackable, Reportable, Notifiable {
    String deviceName;

    FitnessDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    public void logActivity() {
        System.out.println(deviceName + " is logging steps, calories, and heart rate.");
    }

    public void generateReport() {
        System.out.println(deviceName + " generated daily fitness report.");
    }

    public void sendAlert() {
        System.out.println(deviceName + " alert: Goal not completed yet!");
    }
}

public class Main {
    public static void main(String[] args) {
        FitnessDevice watch = new FitnessDevice("FitWatch Pro");

        watch.logActivity();
        watch.generateReport();
        watch.sendAlert();

        watch.resetData();
    }
}
