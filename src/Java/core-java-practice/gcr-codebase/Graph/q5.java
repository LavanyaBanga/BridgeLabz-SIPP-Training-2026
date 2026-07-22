import java.util.*;

public class UndirectedCycleDetection {

    private final Map<Integer, List<Integer>> circuit =
            new HashMap<>();

    public void addWire(int point1, int point2) {
        circuit
                .computeIfAbsent(point1, key -> new ArrayList<>())
                .add(point2);

        circuit
                .computeIfAbsent(point2, key -> new ArrayList<>())
                .add(point1);
    }

    public boolean hasWiringLoop(int numberOfPoints) {
        Set<Integer> visited = new HashSet<>();

        for (int point = 0; point < numberOfPoints; point++) {
            if (!visited.contains(point)) {
                if (detectCycleUsingDFS(point, -1, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean detectCycleUsingDFS(
            int currentPoint,
            int parentPoint,
            Set<Integer> visited
    ) {
        visited.add(currentPoint);

        for (int neighbour :
                circuit.getOrDefault(
                        currentPoint,
                        Collections.emptyList()
                )) {

            if (!visited.contains(neighbour)) {
                if (detectCycleUsingDFS(
                        neighbour,
                        currentPoint,
                        visited
                )) {
                    return true;
                }
            } else if (neighbour != parentPoint) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        UndirectedCycleDetection wiringGraph =
                new UndirectedCycleDetection();

        int numberOfPoints = 5;

        wiringGraph.addWire(0, 1);
        wiringGraph.addWire(1, 2);
        wiringGraph.addWire(2, 3);
        wiringGraph.addWire(3, 0);
        wiringGraph.addWire(3, 4);

        boolean containsCycle =
                wiringGraph.hasWiringLoop(numberOfPoints);

        if (containsCycle) {
            System.out.println("Wiring loop detected.");
        } else {
            System.out.println("No wiring loop detected.");
        }
    }
}
