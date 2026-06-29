interface TextModeration {
    boolean isOffensive(String post);

    default void displayModerationPolicy() {
        System.out.println("Policy: Offensive content is not allowed.");
    }

    static boolean containsRestrictedWords(String post) {
        String lowerPost = post.toLowerCase();
        return lowerPost.contains("hate") || lowerPost.contains("violence");
    }
}

interface SpamDetection {
    boolean isSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("Policy: Spam and repeated promotions are not allowed.");
    }
}

public class ContextModerator implements TextModeration, SpamDetection{
    public boolean isOffensive(String post) {
        return TextModeration.containsRestrictedWords(post);
    }

    public boolean isSpam(String post) {
        String lowerPost = post.toLowerCase();
        return lowerPost.contains("buy now") || lowerPost.contains("free money");
    }

    public void displayModerationPolicy() {
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }

    public static void main(String[] args) {
        ContextModerator moderator = new ContextModerator();

        String[] posts = {
                "This is a beautiful day",
                "Buy now and get free money",
                "This post spreads hate",
                "Java programming is useful"
        };

        moderator.displayModerationPolicy();

        System.out.println();

        for (String post : posts) {
            System.out.println("Post: " + post);

            if (moderator.isSpam(post)) {
                System.out.println("Result: Spam Post");
            } else if (moderator.isOffensive(post)) {
                System.out.println("Result: Offensive Post");
            } else {
                System.out.println("Result: Valid Post");
            }

            System.out.println();
        }
    }
}