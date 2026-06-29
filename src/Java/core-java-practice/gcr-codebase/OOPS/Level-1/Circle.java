class Circle {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    void area() {
        System.out.println("Area = " + (Math.PI * radius * radius));
    }

    void circumference() {
        System.out.println("Circumference = " + (2 * Math.PI * radius));
    }

    public static void main(String[] args) {
        Circle c = new Circle(7);

        c.area();
        c.circumference();
    }
}