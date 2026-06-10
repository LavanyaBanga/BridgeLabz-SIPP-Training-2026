import java.util.Scanner;

public class Feet{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter distance in feet: ");
        double distanceInFeet = input.nextDouble();

        double yards = distanceInFeet / 3;
        double miles = yards / 1760;

        System.out.println("Distance in feet = " + distanceInFeet);
        System.out.println("Distance in yards = " + yards);
        System.out.println("Distance in miles = " + miles);

        input.close();
    }
}