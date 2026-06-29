
interface Worker {
    void performDuties();
}

class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Name : " + name);
        System.out.println("ID   : " + id);
    }
}

class Chef extends Person implements Worker {

    public Chef(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println("Duty : Preparing and cooking food.");
    }
}
class Waiter extends Person implements Worker {

    public Waiter(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println("Duty : Taking orders and serving customers.");
    }
}
public class Main {
    public static void main(String[] args) {

        Chef chef = new Chef("Rahul", 101);
        Waiter waiter = new Waiter("Aman", 201);

        System.out.println("Chef Details");
        chef.displayInfo();
        chef.performDuties();

        System.out.println();

        System.out.println("Waiter Details");
        waiter.displayInfo();
        waiter.performDuties();
    }
}
