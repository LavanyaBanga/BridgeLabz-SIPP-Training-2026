class Vehicle {
    String vehicleName;

    Vehicle(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    double fuelCost(int km) {
        return 0;
    }
}

class Car extends Vehicle {
    Car(String vehicleName) {
        super(vehicleName);
    }

    @Override
    double fuelCost(int km) {
        return km * 8;
    }
}

class Bus extends Vehicle {
    Bus(String vehicleName) {
        super(vehicleName);
    }

    @Override
    double fuelCost(int km) {
        return km * 15;
    }
}

class Bike extends Vehicle {
    Bike(String vehicleName) {
        super(vehicleName);
    }

    @Override
    double fuelCost(int km) {
        return km * 3;
    }
}

class ElectricCar extends Vehicle {
    ElectricCar(String vehicleName) {
        super(vehicleName);
    }

    @Override
    double fuelCost(int km) {
        return km * 2;
    }
}

public class TransportCompany {

    public static void main(String[] args) {

        Vehicle[] vehicles = {
                new Car("Car"),
                new Bus("Bus"),
                new Bike("Bike"),
                new ElectricCar("Electric Car")
        };

        int km = 100;

        for (Vehicle v : vehicles) {

            if (v instanceof Car) {
                Car c = (Car) v;
                System.out.println(c.vehicleName + " Fuel Cost: " + c.fuelCost(km));
            }

            else if (v instanceof Bus) {
                Bus b = (Bus) v;
                System.out.println(b.vehicleName + " Fuel Cost: " + b.fuelCost(km));
            }

            else if (v instanceof Bike) {
                Bike bike = (Bike) v;
                System.out.println(bike.vehicleName + " Fuel Cost: " + bike.fuelCost(km));
            }

            else if (v instanceof ElectricCar) {
                ElectricCar e = (ElectricCar) v;
                System.out.println(e.vehicleName + " Fuel Cost: " + e.fuelCost(km));
            }
        }
    }
}
