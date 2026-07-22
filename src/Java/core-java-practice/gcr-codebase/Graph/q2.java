import java.util.*;

public class FewestConnectingFlights {

    private final Map<Integer, List<Integer>> routes = new HashMap<>();
    public void addRoute(int city1, int city2) {
        routes
                .computeIfAbsent(city1, key -> new ArrayList<>())
                .add(city2);

        routes
                .computeIfAbsent(city2, key -> new ArrayList<>())
                .add(city1);
    }

    public List<Integer> findShortestPath(int origin, int destination) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> parent = new HashMap<>();

        queue.offer(origin);
        visited.add(origin);
        parent.put(origin, null);

        while (!queue.isEmpty()) {
            int currentCity = queue.poll();

            if (currentCity == destination) {
                break;
            }

            for (int nextCity :
                    routes.getOrDefault(currentCity, Collections.emptyList())) {

                if (!visited.contains(nextCity)) {
                    visited.add(nextCity);
                    parent.put(nextCity, currentCity);
                    queue.offer(nextCity);
                }
            }
        }
 
        if (!visited.contains(destination)) {
            return Collections.emptyList();
        }

        LinkedList<Integer> shortestPath = new LinkedList<>();
        Integer currentCity = destination;

        while (currentCity != null) {
            shortestPath.addFirst(currentCity);
            currentCity = parent.get(currentCity);
        }

        return shortestPath;
    }

    public static void main(String[] args) {
        FewestConnectingFlights flightGraph =
                new FewestConnectingFlights();

        flightGraph.addRoute(1, 2);
        flightGraph.addRoute(1, 3);
        flightGraph.addRoute(2, 4);
        flightGraph.addRoute(3, 5);
        flightGraph.addRoute(4, 5);
        flightGraph.addRoute(5, 6);

        int origin = 1;
        int destination = 6;

        List<Integer> shortestPath =
                flightGraph.findShortestPath(origin, destination);

        if (shortestPath.isEmpty()) {
            System.out.println("Destination is unreachable.");
        } else {
            System.out.println("Shortest route: " + shortestPath);
            System.out.println(
                    "Minimum number of flights: " +
                    (shortestPath.size() - 1)
            );
        }
    }
}
