import java.util.Scanner;

public class ElectionBooth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int candidate1 = 0;
        int candidate2 = 0;
        int candidate3 = 0;

        while (true) {
            System.out.print("Enter age (-1 to exit): ");
            int age = sc.nextInt();

            if (age == -1) {
                break;
            }

            if (age >= 18) {
                System.out.println("Eligible to vote");

                System.out.println("Vote for Candidate:");
                System.out.println("1. Candidate A");
                System.out.println("2. Candidate B");
                System.out.println("3. Candidate C");

                int vote = sc.nextInt();

                if (vote == 1) {
                    candidate1++;
                } else if (vote == 2) {
                    candidate2++;
                } else if (vote == 3) {
                    candidate3++;
                } else {
                    System.out.println("Invalid Vote!");
                }

            } else {
                System.out.println("Not Eligible to Vote");
            }

            System.out.println();
        }

        System.out.println("\nElection Results");
        System.out.println("Candidate A Votes: " + candidate1);
        System.out.println("Candidate B Votes: " + candidate2);
        System.out.println("Candidate C Votes: " + candidate3);

        sc.close();
    }
}