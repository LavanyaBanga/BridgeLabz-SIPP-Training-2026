import java.util.*;

class Astronaut {
    String astronautId;
    String name;
    String specialization;

    Astronaut(String astronautId, String name, String specialization) {
        this.astronautId = astronautId;
        this.name = name;
        this.specialization = specialization;
    }

    public String toString() {
        return "ID: " + astronautId +
                ", Name: " + name +
                ", Specialization: " + specialization;
    }
}

public class SpaceMissionCrewManagementSystem {
    HashMap<String, List<Astronaut>> missions = new HashMap<>();
    HashMap<String, HashSet<String>> missionAstronautIds = new HashMap<>();

    void addMission(String missionName) {
        missions.putIfAbsent(missionName, new ArrayList<>());
        missionAstronautIds.putIfAbsent(missionName, new HashSet<>());
        System.out.println("Mission added: " + missionName);
    }

    void assignAstronaut(String missionName, Astronaut astronaut) {
        addMission(missionName);

        HashSet<String> ids = missionAstronautIds.get(missionName);

        if (ids.contains(astronaut.astronautId)) {
            System.out.println("Duplicate assignment not allowed for " + astronaut.name);
        } else {
            missions.get(missionName).add(astronaut);
            ids.add(astronaut.astronautId);
            System.out.println(astronaut.name + " assigned to " + missionName);
        }
    }

    void displayMissions() {
        System.out.println("\nMission Crew Details:");

        for (String mission : missions.keySet()) {
            System.out.println("\nMission: " + mission);

            List<Astronaut> crew = missions.get(mission);
            for (Astronaut astronaut : crew) {
                System.out.println(astronaut);
            }

            System.out.println("Total astronauts: " + crew.size());
        }
    }

    public static void main(String[] args) {
        SpaceMissionCrewManagementSystem system =
                new SpaceMissionCrewManagementSystem();

        Astronaut a1 = new Astronaut("A101", "Neil", "Commander");
        Astronaut a2 = new Astronaut("A102", "Riya", "Engineer");
        Astronaut a3 = new Astronaut("A103", "Aman", "Scientist");

        system.addMission("Moon Mission");
        system.assignAstronaut("Moon Mission", a1);
        system.assignAstronaut("Moon Mission", a2);
        system.assignAstronaut("Moon Mission", a1);

        system.assignAstronaut("Mars Mission", a1);
        system.assignAstronaut("Mars Mission", a3);

        system.displayMissions();
    }
}
