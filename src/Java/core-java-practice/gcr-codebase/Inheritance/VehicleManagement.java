
interface Refuelable {
    void refuel();
}

class Vehicle {
    protected String model;
    protected int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayInfo() {
        System.out.println("Model      : " + model);
        System.out.println("Max Speed  : " + maxSpeed + " km/h");
    }
}

class ElectricVehicle extends Vehicle {

    public ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    public void charge() {
        System.out.println(model + " is charging...");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {

    public PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    
    public void refuel() {
        System.out.println(model + " is being refueled.");
    }
}

public class Main {
    public static void main(String[] args) {

        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 225);

        PetrolVehicle pv = new PetrolVehicle("Toyota Fortuner", 190);

        System.out.println("Electric Vehicle");
        ev.displayInfo();
        ev.charge();

        System.out.println();

        System.out.println("Petrol Vehicle");
        pv.displayInfo();
        pv.refuel();
    }
}=
