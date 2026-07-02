import java.util.*;

public class MusicPlaylistRecommendationEngine {
    LinkedList<String> recentlyPlayed = new LinkedList<>();

    void playSong(String songName) {
        recentlyPlayed.addFirst(songName);

        if (recentlyPlayed.size() > 10) {
            String removedSong = recentlyPlayed.removeLast();
            System.out.println("Oldest song removed: " + removedSong);
        }

        System.out.println("Played: " + songName);
    }

    void searchSong(String songName) {
        if (recentlyPlayed.contains(songName)) {
            System.out.println(songName + " exists in recently played list.");
        } else {
            System.out.println(songName + " not found.");
        }
    }

    void displayHistory() {
        System.out.println("\nRecently Played Songs:");
        for (String song : recentlyPlayed) {
            System.out.println(song);
        }
    }

    public static void main(String[] args) {
        MusicPlaylistRecommendationEngine app =
                new MusicPlaylistRecommendationEngine();

        app.playSong("Perfect");
        app.playSong("Shape of You");
        app.playSong("Kesariya");
        app.playSong("Believer");
        app.playSong("Faded");
        app.playSong("Tum Hi Ho");
        app.playSong("On My Way");
        app.playSong("Night Changes");
        app.playSong("Heeriye");
        app.playSong("Raataan Lambiyan");
        app.playSong("Apna Bana Le");

        app.searchSong("Faded");
        app.displayHistory();
    }
}
