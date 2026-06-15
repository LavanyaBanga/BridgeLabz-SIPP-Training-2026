import java.util.Random;
import java.util.Scanner;

public class DemoCards {

    static String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    static String[] ranks = {
            "2","3","4","5","6","7","8","9","10",
            "Jack","Queen","King","Ace"
    };

    public static String[] createDeck() {

        String[] deck = new String[52];

        int k = 0;

        for (String s : suits) {
            for (String r : ranks) {
                deck[k++] = r + " of " + s;
            }
        }

        return deck;
    }

    public static void shuffle(String[] deck) {

        Random r = new Random();

        for (int i = 0; i < deck.length; i++) {

            int j = i + r.nextInt(deck.length - i);

            String temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    public static String[][] distribute(String[] deck, int players, int cards) {

        if (players * cards > deck.length)
            return null;

        String[][] table = new String[players][cards];

        int index = 0;

        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cards; j++) {
                table[i][j] = deck[index++];
            }
        }

        return table;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int players = sc.nextInt();
        int cards = sc.nextInt();

        String[] deck = createDeck();

        shuffle(deck);

        String[][] result = distribute(deck, players, cards);

        if (result == null) {
            System.out.println("Not possible");
            return;
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " | ");
            }
            System.out.println();
        }
    }
}