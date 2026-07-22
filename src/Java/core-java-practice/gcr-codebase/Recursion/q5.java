public class ErrorCodeSearch {

    public static boolean exists(
            char[][] logGrid,
            String errorCode
    ) {

        if (logGrid == null ||
                logGrid.length == 0 ||
                errorCode == null) {
            return false;
        }

        if (errorCode.isEmpty()) {
            return true;
        }

        int rows = logGrid.length;
        int columns = logGrid[0].length;

        boolean[][] visited =
                new boolean[rows][columns];

      
        for (int row = 0; row < rows; row++) {

            for (int column = 0;
                 column < columns;
                 column++) {

                if (searchPath(
                        logGrid,
                        errorCode,
                        0,
                        row,
                        column,
                        visited
                )) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean searchPath(
            char[][] logGrid,
            String errorCode,
            int characterIndex,
            int row,
            int column,
            boolean[][] visited
    ) {


        if (characterIndex == errorCode.length()) {
            return true;
        }

      
        if (row < 0 ||
                row >= logGrid.length ||
                column < 0 ||
                column >= logGrid[0].length) {
            return false;
        }

      
        if (visited[row][column]) {
            return false;
        }

      
        if (logGrid[row][column]
                != errorCode.charAt(characterIndex)) {
            return false;
        }

    
        visited[row][column] = true;

        boolean pathFound =
                searchPath(
                        logGrid,
                        errorCode,
                        characterIndex + 1,
                        row + 1,
                        column,
                        visited
                )
                ||
                searchPath(
                        logGrid,
                        errorCode,
                        characterIndex + 1,
                        row - 1,
                        column,
                        visited
                )
                ||
                searchPath(
                        logGrid,
                        errorCode,
                        characterIndex + 1,
                        row,
                        column + 1,
                        visited
                )
                ||
                searchPath(
                        logGrid,
                        errorCode,
                        characterIndex + 1,
                        row,
                        column - 1,
                        visited
                );

        
        visited[row][column] = false;

        return pathFound;
    }

    public static void main(String[] args) {

        char[][] logGrid = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String errorCode1 = "ABCCED";
        String errorCode2 = "SEE";
        String errorCode3 = "ABCB";

        System.out.println(
                errorCode1 + " exists: "
                        + exists(logGrid, errorCode1)
        );

        System.out.println(
                errorCode2 + " exists: "
                        + exists(logGrid, errorCode2)
        );

        System.out.println(
                errorCode3 + " exists: "
                        + exists(logGrid, errorCode3)
        );
    }
}
