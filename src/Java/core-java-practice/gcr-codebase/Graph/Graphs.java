import java.util.*;

public class SparseFriendGraph {

    private final Map<Integer, Set<Integer>> friendGraph = new HashMap<>();
    public void addFriendship(int user1, int user2) {
        friendGraph
                .computeIfAbsent(user1, key -> new HashSet<>())
                .add(user2);

        friendGraph
                .computeIfAbsent(user2, key -> new HashSet<>())
                .add(user1);
    }
    public boolean isFriend(int user1, int user2) {
        return friendGraph
                .getOrDefault(user1, Collections.emptySet())
                .contains(user2);
    }

    public void displayGraph() {
        for (Map.Entry<Integer, Set<Integer>> entry : friendGraph.entrySet()) {
            System.out.println(
                    "User " + entry.getKey() +
                    " -> Friends " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {
        SparseFriendGraph graph = new SparseFriendGraph();

        graph.addFriendship(1, 2);
        graph.addFriendship(1, 3);
        graph.addFriendship(2, 4);
        graph.addFriendship(3, 5);

        graph.displayGraph();

        System.out.println("Are 1 and 3 friends? " + graph.isFriend(1, 3));
        System.out.println("Are 1 and 4 friends? " + graph.isFriend(1, 4));
        System.out.println("Are 2 and 4 friends? " + graph.isFriend(2, 4));
    }
}
