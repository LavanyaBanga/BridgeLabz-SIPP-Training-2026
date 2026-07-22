import java.util.*;

public class CompanyNetworkConnectivity {

    private final Map<Integer, List<Integer>> network =
            new HashMap<>();

    public void addConnection(int server1, int server2) {
        network
                .computeIfAbsent(server1, key -> new ArrayList<>())
                .add(server2);

        network
                .computeIfAbsent(server2, key -> new ArrayList<>())
                .add(server1);
    }

    public int countNetworkSegments(int numberOfServers) {
        Set<Integer> visited = new HashSet<>();
        int segments = 0;

        for (int server = 0; server < numberOfServers; server++) {
            if (!visited.contains(server)) {
                segments++;
                markConnectedServers(server, visited);
            }
        }

        return segments;
    }

    private void markConnectedServers(
            int currentServer,
            Set<Integer> visited
    ) {
        visited.add(currentServer);

        for (int connectedServer :
                network.getOrDefault(
                        currentServer,
                        Collections.emptyList()
                )) {

            if (!visited.contains(connectedServer)) {
                markConnectedServers(connectedServer, visited);
            }
        }
    }

    public static void main(String[] args) {
        CompanyNetworkConnectivity companyNetwork =
                new CompanyNetworkConnectivity();

        int numberOfServers = 7;

      
        companyNetwork.addConnection(0, 1);
        companyNetwork.addConnection(1, 2);

       
        companyNetwork.addConnection(3, 4);

      
        companyNetwork.addConnection(5, 6);

        int segments =
                companyNetwork.countNetworkSegments(numberOfServers);

        System.out.println("Number of network segments: " + segments);

        if (segments == 1) {
            System.out.println("The network is fully connected.");
        } else {
            System.out.println("The network is not fully connected.");
        }
    }
}
