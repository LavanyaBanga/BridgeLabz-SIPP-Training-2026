import java.util.Scanner;

public class FriendInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Amar's age and height: ");
        int amarAge = sc.nextInt();
        double amarHeight = sc.nextDouble();

        System.out.print("Enter Akbar's age and height: ");
        int akbarAge = sc.nextInt();
        double akbarHeight = sc.nextDouble();

        System.out.print("Enter Anthony's age and height: ");
        int anthonyAge = sc.nextInt();
        double anthonyHeight = sc.nextDouble();
        if (amarAge < akbarAge && amarAge < anthonyAge)
            System.out.println("Youngest Friend: Amar");
        else if (akbarAge < anthonyAge)
            System.out.println("Youngest Friend: Akbar");
        else
            System.out.println("Youngest Friend: Anthony");
        if (amarHeight > akbarHeight && amarHeight > anthonyHeight)
            System.out.println("Tallest Friend: Amar");
        else if (akbarHeight > anthonyHeight)
            System.out.println("Tallest Friend: Akbar");
        else
            System.out.println("Tallest Friend: Anthony");
    }
}