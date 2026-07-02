import java.util.*;

public class SmartCityTrafficMonitoringSystem {
    HashMap<String, Integer> trafficData = new HashMap<>();

    void addOrUpdateRoad(String roadName, int vehicleCount) {
        trafficData.put(roadName, vehicleCount);
        System.out.println("Traffic updated for " + roadName);
    }

    void displaySortedRoads() {
        TreeMap<String, Integer> sortedRoads = new TreeMap<>(trafficData);

        System.out.println("\nRoads in Sorted Order:");
        for (String road : sortedRoads.keySet()) {
            System.out.println(road + " : " + sortedRoads.get(road) + " vehicles");
        }
    }

    void displayBusiestRoad() {
        String busiestRoad = null;
        int maxVehicles = 0;

        for (String road : trafficData.keySet()) {
            int count = trafficData.get(road);

            if (count > maxVehicles) {
                maxVehicles = count;
                busiestRoad = road;
            }
        }

        if (busiestRoad != null) {
            System.out.println("\nBusiest Road: " + busiestRoad);
            System.out.println("Vehicles: " + maxVehicles);
        } else {
            System.out.println("No traffic data available.");
        }
    }

    void generateReport() {
        System.out.println("\nTraffic Analysis Report:");

        for (String road : trafficData.keySet()) {
            int count = trafficData.get(road);
            String status;

            if (count >= 1000) {
                status = "Heavy Traffic";
            } else if (count >= 500) {
                status = "Moderate Traffic";
            } else {
                status = "Low Traffic";
            }

            System.out.println(road + " -> " + count + " vehicles -> " + status);
        }

        System.out.println("Total roads monitored: " + trafficData.size());
    }

    public static void main(String[] args) {
        SmartCityTrafficMonitoringSystem system =
                new SmartCityTrafficMonitoringSystem();

        system.addOrUpdateRoad("MG Road", 850);
        system.addOrUpdateRoad("Ring Road", 1300);
        system.addOrUpdateRoad("Civil Lines", 420);
        system.addOrUpdateRoad("Airport Road", 950);

        system.displaySortedRoads();
        system.displayBusiestRoad();
        system.generateReport();
    }
}
