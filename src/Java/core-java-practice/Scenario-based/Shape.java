public abstract class Shape {

    abstract double calculateArea();
    abstract double calculatePerimeter();

    void display() {
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
    }

    public static void main(String[] args) {

        CircleShape c = new CircleShape(7);
        RectangleShape r = new RectangleShape(10, 5);
        TriangleShape t = new TriangleShape(3, 4, 5);

        System.out.println("----- Circle -----");
        c.display();

        System.out.println();

        System.out.println("----- Rectangle -----");
        r.display();

        System.out.println();

        System.out.println("----- Triangle -----");
        t.display();
    }
}

class CircleShape extends Shape {
    double radius;

    CircleShape(double radius) {
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class RectangleShape extends Shape {
    double length;
    double breadth;

    RectangleShape(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    double calculateArea() {
        return length * breadth;
    }

    double calculatePerimeter() {
        return 2 * (length + breadth);
    }
}

class TriangleShape extends Shape {
    double a, b, c;

    TriangleShape(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    double calculateArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    double calculatePerimeter() {
        return a + b + c;
    }
}