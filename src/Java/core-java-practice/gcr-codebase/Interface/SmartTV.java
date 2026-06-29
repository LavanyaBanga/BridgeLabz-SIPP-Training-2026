interface StreamingService {
    void streamMovie(String movieName);

    default void showSubscriptionDetails() {
        System.out.println("Streaming subscription active.");
    }
}

interface GamingService {
    void playGame(String gameName);

    default void showSubscriptionDetails() {
        System.out.println("Gaming subscription active.");
    }
}

public class SmartTV implements StreamingService, GamingService {

    public void streamMovie(String movieName) {
        System.out.println("Streaming movie: " + movieName);
    }

    public void playGame(String gameName) {
        System.out.println("Playing game: " + gameName);
    }

    public void showSubscriptionDetails() {
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
    }

    public static void main(String[] args) {
        SmartTV tv = new SmartTV();

        String[] movies = {"Avengers", "Inception", "Interstellar"};
        String[] games = {"FIFA", "GTA", "Minecraft"};

        tv.showSubscriptionDetails();

        System.out.println();

        for (String movie : movies) {
            tv.streamMovie(movie);
        }

        System.out.println();

        for (String game : games) {
            tv.playGame(game);
        }
    }
}