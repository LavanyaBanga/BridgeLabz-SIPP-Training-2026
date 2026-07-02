import java.util.*;

public class SmartParkingSlotManager {
    ArrayList<String> vehicles = new ArrayList<>();

    void enterVehicle(String regNo) {
        vehicles.add(regNo);
        System.out.println(regNo + " entered parking.");
    }

    void exitVehicle(String regNo) {
        if (vehicles.remove(regNo)) {
            System.out.println(regNo + " exited parking.");
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    void searchVehicle(String regNo) {
        if (vehicles.contains(regNo)) {
            System.out.println(regNo + " is currently parked.");
        } else {
            System.out.println(regNo + " is not parked.");
        }
    }

    void displayVehicles() {
        System.out.println("\nParked Vehicles:");
        for (String v : vehicles) {
            System.out.println(v);
        }
        System.out.println("Total occupied slots: " + vehicles.size());
    }

    public static void main(String[] args) {
        SmartParkingSlotManager manager = new SmartParkingSlotManager();

        manager.enterVehicle("UP85AB1234");
        manager.enterVehicle("DL01CD5678");
        manager.enterVehicle("HR26EF9999");

        manager.searchVehicle("DL01CD5678");
        manager.exitVehicle("UP85AB1234");

        manager.displayVehicles();
    }
}
