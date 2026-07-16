import java.util.HashSet;

public class DuplicateSessionToken {

    // Function to check duplicate session tokens
    public static boolean hasDuplicateToken(String[] tokens) {

        HashSet<String> seen = new HashSet<>();

        for (String token : tokens) {

            // If token already exists
            if (!seen.add(token)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String[] tokens = {
            "ABC123",
            "XYZ456",
            "LMN789",
            "ABC123",
            "PQR111"
        };

        if (hasDuplicateToken(tokens)) {
            System.out.println("Duplicate Token Found");
        } else {
            System.out.println("No Duplicate Token");
        }
    }
}
