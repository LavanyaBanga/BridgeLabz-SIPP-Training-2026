class Employee1{
    double radius;

    Employee1(double radius) {
        this.radius = radius;
    }

    void area() {
        System.out.println("Area = " + (Math.PI * radius * radius));
    }

    void circumference() {
        System.out.println("Circumference = " + (2 * Math.PI * radius));
    }

    public static void main(String[] args) {
        Employee1 c = new Employee1(7);

        c.area();
        c.circumference();
    }
}