class TollVehicle {
    String vehicleNumber;
    String ownerName;

    TollVehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    double calculateToll() {
        return 0;
    }

    void displayDetails() {
        System.out.println(vehicleNumber + " - " + ownerName + " - Toll: " + calculateToll());
    }
}

class TollCar extends TollVehicle {
    TollCar(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    double calculateToll() {
        return 100;
    }
}

class TollBus extends TollVehicle {
    TollBus(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    double calculateToll() {
        return 250;
    }
}

class TollTruck extends TollVehicle {
    TollTruck(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    double calculateToll() {
        return 400;
    }
}

public class SmartVehicleTollSystem {

    static double calculateTotalRevenue(TollVehicle[] vehicles) {
        double total = 0;
        for (TollVehicle v : vehicles) {
            total += v.calculateToll();
        }
        return total;
    }

    static void searchVehicle(TollVehicle[] vehicles, String vehicleNumber) {
        for (TollVehicle v : vehicles) {
            if (v.vehicleNumber.equals(vehicleNumber)) {
                System.out.println("Vehicle Found:");
                v.displayDetails();
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }

    public static void main(String[] args) {
        TollVehicle[] vehicles = {
                new TollCar("UP85A1010", "Lavanya"),
                new TollBus("UP85B2020", "Riya"),
                new TollTruck("UP85T3030", "Aman")
        };

        int carCount = 0, busCount = 0, truckCount = 0;
        TollVehicle highest = vehicles[0];

        for (TollVehicle v : vehicles) {
            v.displayDetails();

            if (v.calculateToll() > highest.calculateToll()) {
                highest = v;
            }

            if (v instanceof TollCar) carCount++;
            else if (v instanceof TollBus) busCount++;
            else if (v instanceof TollTruck) truckCount++;
        }

        System.out.println("Total Revenue: " + calculateTotalRevenue(vehicles));

        System.out.println("Highest Toll Paid By:");
        highest.displayDetails();

        System.out.println("Cars: " + carCount);
        System.out.println("Buses: " + busCount);
        System.out.println("Trucks: " + truckCount);

        searchVehicle(vehicles, "UP85B2020");
    }
}
