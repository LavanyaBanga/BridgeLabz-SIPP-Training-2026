import java.util.*;

public class AllDeliveryRoutes {

    private final Map<Integer, List<Integer>> roadNetwork =
            new HashMap<>();

    public void addRoad(int location1, int location2) {
        roadNetwork
                .computeIfAbsent(location1, key -> new ArrayList<>())
                .add(location2);

        roadNetwork
                .computeIfAbsent(location2, key -> new ArrayList<>())
                .add(location1);
    }

    public List<List<Integer>> findAllRoutes(int source, int destination) {
        List<List<Integer>> allRoutes = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        findRoutesUsingDFS(
                source,
                destination,
                currentPath,
                visited,
                allRoutes
        );

        return allRoutes;
    }

    private void findRoutesUsingDFS(
            int currentLocation,
            int destination,
            List<Integer> currentPath,
            Set<Integer> visited,
            List<List<Integer>> allRoutes
    ) {
        currentPath.add(currentLocation);
        visited.add(currentLocation);

        if (currentLocation == destination) {
            allRoutes.add(new ArrayList<>(currentPath));
        } else {
            for (int nextLocation :
                    roadNetwork.getOrDefault(
                            currentLocation,
                            Collections.emptyList()
                    )) {

                if (!visited.contains(nextLocation)) {
                    findRoutesUsingDFS(
                            nextLocation,
                            destination,
                            currentPath,
                            visited,
                            allRoutes
                    );
                }
            }
        }

    
        currentPath.remove(currentPath.size() - 1);
        visited.remove(currentLocation);
    }

    public static void main(String[] args) {
        AllDeliveryRoutes deliveryGraph =
                new AllDeliveryRoutes();

        deliveryGraph.addRoad(0, 1);
        deliveryGraph.addRoad(0, 2);
        deliveryGraph.addRoad(1, 2);
        deliveryGraph.addRoad(1, 3);
        deliveryGraph.addRoad(2, 3);

        int warehouse = 0;
        int store = 3;

        List<List<Integer>> routes =
                deliveryGraph.findAllRoutes(warehouse, store);

        System.out.println(
                "All delivery routes from " +
                warehouse + " to " + store + ":"
        );

        for (List<Integer> route : routes) {
            System.out.println(route);
        }
    }
}
