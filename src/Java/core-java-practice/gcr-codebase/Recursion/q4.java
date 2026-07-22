import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SensorPlacement {

    public static List<List<String>> placeSensors(int gridSize) {

        List<List<String>> allPlacements = new ArrayList<>();

        int[] sensorColumn = new int[gridSize];
        Arrays.fill(sensorColumn, -1);

        placeSensorInRow(
                gridSize,
                0,
                sensorColumn,
                allPlacements
        );

        return allPlacements;
    }

    private static void placeSensorInRow(
            int gridSize,
            int currentRow,
            int[] sensorColumn,
            List<List<String>> allPlacements
    ) {

     
        if (currentRow == gridSize) {
            allPlacements.add(buildGrid(gridSize, sensorColumn));
            return;
        }

        for (int column = 0; column < gridSize; column++) {

            if (isSafe(currentRow, column, sensorColumn)) {

              
                sensorColumn[currentRow] = column;

                placeSensorInRow(
                        gridSize,
                        currentRow + 1,
                        sensorColumn,
                        allPlacements
                );

              
                sensorColumn[currentRow] = -1;
            }
        }
    }

    private static boolean isSafe(
            int currentRow,
            int currentColumn,
            int[] sensorColumn
    ) {

        for (int previousRow = 0;
             previousRow < currentRow;
             previousRow++) {

            int previousColumn = sensorColumn[previousRow];
 
            if (previousColumn == currentColumn) {
                return false;
            }

          
            int columnDifference =
                    Math.abs(previousColumn - currentColumn);

            int rowDifference =
                    Math.abs(previousRow - currentRow);

            if (columnDifference == rowDifference) {
                return false;
            }
        }

        return true;
    }

    private static List<String> buildGrid(
            int gridSize,
            int[] sensorColumn
    ) {

        List<String> grid = new ArrayList<>();

        for (int row = 0; row < gridSize; row++) {

            char[] currentRow = new char[gridSize];
            Arrays.fill(currentRow, '.');

            currentRow[sensorColumn[row]] = 'S';

            grid.add(new String(currentRow));
        }

        return grid;
    }

    public static void main(String[] args) {

        int gridSize = 4;

        List<List<String>> placements =
                placeSensors(gridSize);

        System.out.println("Valid sensor placements:");

        int placementNumber = 1;

        for (List<String> placement : placements) {

            System.out.println(
                    "\nPlacement " + placementNumber + ":"
            );

            for (String row : placement) {
                System.out.println(row);
            }

            placementNumber++;
        }

        System.out.println(
                "\nTotal placements: " + placements.size()
        );
    }
}
