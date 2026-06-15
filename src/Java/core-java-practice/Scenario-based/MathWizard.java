public class MathWizard {
    int instanceValue = 100;
    public boolean isPrime(int n) {

        if (n <= 1) return false;

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
    public long factorial(int n) {

        long fact = 1; // local variable

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

    public double factorial(double n) {

        double fact = 1.0;

        for (int i = 1; i <= (int)n; i++) {
            fact *= i;
        }

        return fact;
    }


    public void fibonacci(int n) {

        int a = 0, b = 1; // local variables

        System.out.print("Fibonacci: ");

        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }

        System.out.println();
    }

    public int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
    public int lcm(int a, int b) {

        return (a * b) / gcd(a, b);
    }


    public long power(int base, int exp) {

        long result = 1; // local variable

        for (int i = 1; i <= exp; i++) {
            result *= base;
        }

        return result;
    }

    public void scopeDemo() {

        int localValue = 50; // local variable

        System.out.println("Instance variable = " + instanceValue);
        System.out.println("Local variable = " + localValue);
    }


    public static void main(String[] args) {

        MathWizard mw = new MathWizard();

        int n = 5;

        System.out.println("Is Prime: " + mw.isPrime(n));

        System.out.println("Factorial (int): " + mw.factorial(n));
        System.out.println("Factorial (double): " + mw.factorial(5.0));

        mw.fibonacci(10);

        System.out.println("GCD: " + mw.gcd(12, 18));
        System.out.println("LCM: " + mw.lcm(12, 18));

        System.out.println("Power: " + mw.power(2, 5));

        // Scope demo
        mw.scopeDemo();
    }
}