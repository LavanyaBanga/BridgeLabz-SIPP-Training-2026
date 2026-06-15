import java.util.Scanner;

public class check {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        System.out.println("Enter 5 numbers:");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for (int num : arr) {
            if (num > 0) {
                if (num % 2 == 0) {
                    System.out.println(num + " is Positive and Even");
                } else {
                    System.out.println(num + " is Positive and Odd");
                }
            }
            else if (num < 0) {
                System.out.println(num + " is Negative");
            }
            else {
                System.out.println("Zero");
            }
        }

        if (arr[0] == arr[4]) {
            System.out.println("First and Last elements are Equal");
        }
        else if (arr[0] > arr[4]) {
            System.out.println("First element is Greater");
        }
        else {
            System.out.println("First element is Less");
        }

        sc.close();
    }
}