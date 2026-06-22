import java.util.Scanner;

public class UnitConvertor3 {

    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Fahrenheit: ");
        double f = sc.nextDouble();
        System.out.println("Celsius = " + convertFahrenheitToCelsius(f));

        System.out.print("Enter Celsius: ");
        double c = sc.nextDouble();
        System.out.println("Fahrenheit = " + convertCelsiusToFahrenheit(c));

        System.out.print("Enter pounds: ");
        double pounds = sc.nextDouble();
        System.out.println("Kilograms = " + convertPoundsToKilograms(pounds));

        System.out.print("Enter kilograms: ");
        double kg = sc.nextDouble();
        System.out.println("Pounds = " + convertKilogramsToPounds(kg));

        System.out.print("Enter gallons: ");
        double gallons = sc.nextDouble();
        System.out.println("Liters = " + convertGallonsToLiters(gallons));

        System.out.print("Enter liters: ");
        double liters = sc.nextDouble();
        System.out.println("Gallons = " + convertLitersToGallons(liters));
    }
}