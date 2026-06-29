class FleetVehicle {
    String vehicleName;

    FleetVehicle(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    double fuelCost(int km) {
        return 0;
    }
}

class FleetCar extends FleetVehicle {
    FleetCar(String vehicleName) {
        super(vehicleName);
    }

    double fuelCost(int km) {
        return km * 8;
    }
}

class FleetBus extends FleetVehicle {
    FleetBus(String vehicleName) {
        super(vehicleName);
    }

    double fuelCost(int km) {
        return km * 15;
    }
}

class FleetBike extends FleetVehicle {
    FleetBike(String vehicleName) {
        super(vehicleName);
    }

    double fuelCost(int km) {
        return km * 3;
    }
}

class ElectricCar extends FleetVehicle {
    ElectricCar(String vehicleName) {
        super(vehicleName);
    }

    double fuelCost(int km) {
        return km * 2;
    }
}

public class TransportFleetSystem {
    public static void main(String[] args) {
        FleetVehicle[] vehicles = {
                new FleetCar("Car"),
                new FleetBus("Bus"),
                new FleetBike("Bike"),
                new ElectricCar("Electric Car")
        };

        int km = 100;

        for (FleetVehicle v : vehicles) {
            if (v instanceof FleetVehicle) {
                System.out.println(v.vehicleName + " fuel cost: " + v.fuelCost(km));
            }
        }
    }
}
