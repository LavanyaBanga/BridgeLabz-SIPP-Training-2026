import java.util.ArrayList;
import java.util.List;

public class OnCallScheduling {

    public static List<List<String>> generateSchedules(String[] engineers) {

        List<List<String>> allSchedules = new ArrayList<>();
        boolean[] used = new boolean[engineers.length];

        createSchedules(
                engineers,
                used,
                new ArrayList<>(),
                allSchedules
        );

        return allSchedules;
    }

    private static void createSchedules(
            String[] engineers,
            boolean[] used,
            List<String> currentSchedule,
            List<List<String>> allSchedules
    ) {

     
        if (currentSchedule.size() == engineers.length) {
            allSchedules.add(new ArrayList<>(currentSchedule));
            return;
        }

        for (int i = 0; i < engineers.length; i++) {

            // Engineer already included in current schedule
            if (used[i]) {
                continue;
            }

          
            used[i] = true;
            currentSchedule.add(engineers[i]);

            createSchedules(
                    engineers,
                    used,
                    currentSchedule,
                    allSchedules
            );

            // Backtracking
            currentSchedule.remove(currentSchedule.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {

        String[] engineers = {
                "Aman",
                "Riya",
                "Karan"
        };

        List<List<String>> schedules =
                generateSchedules(engineers);

        System.out.println("All possible on-call schedules:");

        for (int i = 0; i < schedules.size(); i++) {
            System.out.println((i + 1) + ". " + schedules.get(i));
        }

        System.out.println("Total schedules: " + schedules.size());
    }
}
