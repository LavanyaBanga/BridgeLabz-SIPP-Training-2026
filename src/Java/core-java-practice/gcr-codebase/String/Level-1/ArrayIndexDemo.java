import java.util.Scanner;

public class ArrayIndexDemo {

    public static void generateException(String[] names) {
        System.out.println(names[names.length]);
    }

    public static void handleException(String[] names) {

        try {

            System.out.println(names[names.length]);

        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException Handled");
        }
        catch (RuntimeException e) {
            System.out.println("RuntimeException Handled");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] names = new String[3];

        System.out.println("Enter 3 Names:");

        for (int i = 0; i < names.length; i++) {
            names[i] = sc.next();
        }

        // generateException(names);

        handleException(names);

        sc.close();
    }
}