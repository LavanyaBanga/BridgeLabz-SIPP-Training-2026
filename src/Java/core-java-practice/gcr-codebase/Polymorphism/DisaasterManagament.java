class RescueTeam {
    String teamId;
    String location;

    RescueTeam(String teamId, String location) {
        this.teamId = teamId;
        this.location = location;
    }

    void performDuty() {
        System.out.println("Rescue team performing duty.");
    }

    void displayDetails() {
        System.out.println(teamId + " - " + location);
    }
}

class MedicalTeam extends RescueTeam {
    MedicalTeam(String teamId, String location) {
        super(teamId, location);
    }

    void performDuty() {
        System.out.println(teamId + " Medical Team provides first aid at " + location);
    }
}

class FireRescueTeam extends RescueTeam {
    FireRescueTeam(String teamId, String location) {
        super(teamId, location);
    }

    void performDuty() {
        System.out.println(teamId + " Fire Rescue Team controls fire at " + location);
    }
}

class FoodSupplyTeam extends RescueTeam {
    FoodSupplyTeam(String teamId, String location) {
        super(teamId, location);
    }

    void performDuty() {
        System.out.println(teamId + " Food Supply Team distributes food at " + location);
    }
}

public class DisasterRescueManagementSystem {

    static void findTeamByLocation(RescueTeam[] teams, String location) {
        for (RescueTeam t : teams) {
            if (t.location.equalsIgnoreCase(location)) {
                t.displayDetails();
            }
        }
    }

    static void displayTeamsByPrefix(RescueTeam[] teams, String prefix) {
        for (RescueTeam t : teams) {
            if (t.teamId.startsWith(prefix)) {
                t.displayDetails();
            }
        }
    }

    public static void main(String[] args) {
        RescueTeam[] teams = {
                new MedicalTeam("M101", "Delhi"),
                new FireRescueTeam("F201", "Mumbai"),
                new FoodSupplyTeam("FO301", "Delhi"),
                new MedicalTeam("M102", "Chennai")
        };

        int medical = 0, fire = 0, food = 0;

        for (RescueTeam t : teams) {
            t.performDuty();

            if (t instanceof MedicalTeam) medical++;
            else if (t instanceof FireRescueTeam) fire++;
            else if (t instanceof FoodSupplyTeam) food++;
        }

        System.out.println("Medical Teams: " + medical);
        System.out.println("Fire Rescue Teams: " + fire);
        System.out.println("Food Supply Teams: " + food);

        if (medical >= fire && medical >= food) {
            System.out.println("Maximum Deployment: Medical Team");
        } else if (fire >= medical && fire >= food) {
            System.out.println("Maximum Deployment: Fire Rescue Team");
        } else {
            System.out.println("Maximum Deployment: Food Supply Team");
        }

        System.out.println("Teams in Delhi:");
        findTeamByLocation(teams, "Delhi");

        System.out.println("Teams with prefix M:");
        displayTeamsByPrefix(teams, "M");
    }
}
