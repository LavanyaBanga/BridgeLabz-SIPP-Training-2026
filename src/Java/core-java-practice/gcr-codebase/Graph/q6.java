import java.util.*;

public class DirectedCycleDetection {

    private final Map<Integer, List<Integer>> taskGraph =
            new HashMap<>();


    public void addDependency(int task, int dependentTask) {
        taskGraph
                .computeIfAbsent(task, key -> new ArrayList<>())
                .add(dependentTask);
    }

    public boolean hasCircularDependency(int numberOfTasks) {
        int[] state = new int[numberOfTasks];

        for (int task = 0; task < numberOfTasks; task++) {
            if (state[task] == 0) {
                if (detectCycleUsingDFS(task, state)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean detectCycleUsingDFS(
            int currentTask,
            int[] state
    ) {
       
        state[currentTask] = 1;

        for (int dependentTask :
                taskGraph.getOrDefault(
                        currentTask,
                        Collections.emptyList()
                )) {
  
            if (state[dependentTask] == 1) {
                return true;
            }

         
            if (state[dependentTask] == 0 &&
                    detectCycleUsingDFS(dependentTask, state)) {
                return true;
            }
        }

       
        state[currentTask] = 2;
        return false;
    }

    public static void main(String[] args) {
        DirectedCycleDetection buildSystem =
                new DirectedCycleDetection();

        int numberOfTasks = 5;

        buildSystem.addDependency(0, 1);
        buildSystem.addDependency(1, 2);
        buildSystem.addDependency(2, 3);
        buildSystem.addDependency(3, 1);
        buildSystem.addDependency(3, 4);

        boolean containsCycle =
                buildSystem.hasCircularDependency(numberOfTasks);

        if (containsCycle) {
            System.out.println("Circular dependency detected.");
        } else {
            System.out.println("No circular dependency detected.");
        }
    }
}
