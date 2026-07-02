abstract class Vehicle {
    String name;

    Vehicle(String name) {
        this.name = name;
    }

    abstract double fuelCost(double km);
}

class Car extends Vehicle {
    Car(String name) {
        super(name);
    }

    double fuelCost(double km) {
        return km * 8;   // ₹8 per km
    }

    void carFeature() {
        System.out.println(name + " has AC.");
    }
}

class Bus extends Vehicle {
    Bus(String name) {
        super(name);
    }

    double fuelCost(double km) {
        return km * 20;  // ₹20 per km
    }

    void busFeature() {
        System.out.println(name + " has 40 seats.");
    }
}

class Bike extends Vehicle {
    Bike(String name) {
        super(name);
    }

    double fuelCost(double km) {
        return km * 3;   // ₹3 per km
    }

    void bikeFeature() {
        System.out.println(name + " gives high mileage.");
    }
}

class ElectricCar extends Vehicle {
    ElectricCar(String name) {
        super(name);
    }

    double fuelCost(double km) {
        return km * 2;   // charging cost ₹2 per km
    }

    void electricFeature() {
        System.out.println(name + " runs on battery.");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle[] fleet = {
                new Car("Swift"),
                new Bus("Volvo Bus"),
                new Bike("Splendor"),
                new ElectricCar("Tesla")
        };

        double km = 100;

        for (Vehicle v : fleet) {
            System.out.println("--------------------");
            System.out.println("Vehicle: " + v.name);
            System.out.println("Fuel Cost for " + km + " km: ₹" + v.fuelCost(km));

            if (v instanceof Car) {
                Car c = (Car) v;
                c.carFeature();
            } else if (v instanceof Bus) {
                Bus b = (Bus) v;
                b.busFeature();
            } else if (v instanceof Bike) {
                Bike b = (Bike) v;
                b.bikeFeature();
            } else if (v instanceof ElectricCar) {
                ElectricCar e = (ElectricCar) v;
                e.electricFeature();
            }
        }
    }
}
