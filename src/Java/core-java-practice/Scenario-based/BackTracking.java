import java.util.*;

public class BacktrackingProblems {

    // =================================================
    // 1. N-QUEENS USING BACKTRACKING + PRUNING
    // =================================================

    static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];

        placeQueen(0, board, ans, cols, diag1, diag2);

        return ans;
    }

    static void placeQueen(int row, char[][] board, List<List<String>> ans,
                           boolean[] cols, boolean[] diag1, boolean[] diag2) {

        int n = board.length;

        if (row == n) {
            ans.add(buildBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {

            int d1 = row - col + n - 1;
            int d2 = row + col;

            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }

            board[row][col] = 'Q';
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            placeQueen(row + 1, board, ans, cols, diag1, diag2);

            board[row][col] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }

    static List<String> buildBoard(char[][] board) {
        List<String> list = new ArrayList<>();

        for (char[] row : board) {
            list.add(new String(row));
        }

        return list;
    }

    // =================================================
    // 2. GENERATE ALL PERMUTATIONS OF SECRET CODE
    // =================================================

    static List<String> permutations(String code) {
        List<String> ans = new ArrayList<>();
        boolean[] used = new boolean[code.length()];

        backtrackPerm(code, new StringBuilder(), used, ans);

        return ans;
    }

    static void backtrackPerm(String code, StringBuilder path,
                              boolean[] used, List<String> ans) {

        if (path.length() == code.length()) {
            ans.add(path.toString());
            return;
        }

        for (int i = 0; i < code.length(); i++) {

            if (used[i]) continue;

            used[i] = true;
            path.append(code.charAt(i));

            backtrackPerm(code, path, used, ans);

            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }

    // =================================================
    // 3. GENERATE ALL SUBSETS OF INVENTORY ITEMS
    // =================================================

    static List<List<String>> subsets(String[] items) {
        List<List<String>> ans = new ArrayList<>();

        backtrackSubsets(items, 0, new ArrayList<>(), ans);

        return ans;
    }

    static void backtrackSubsets(String[] items, int index,
                                 List<String> path,
                                 List<List<String>> ans) {

        if (index == items.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // not pick
        backtrackSubsets(items, index + 1, path, ans);

        // pick
        path.add(items[index]);
        backtrackSubsets(items, index + 1, path, ans);
        path.remove(path.size() - 1);
    }

    // =================================================
    // 4. COMBINATION SUM TARGET BUDGET
    // =================================================

    static List<List<Integer>> combinationSum(int[] costs, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(costs);

        backtrackCombination(costs, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    static void backtrackCombination(int[] costs, int target, int index,
                                     List<Integer> path,
                                     List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        if (target < 0) return;

        for (int i = index; i < costs.length; i++) {

            if (costs[i] > target) break;

            path.add(costs[i]);

            // i because same item can be reused
            backtrackCombination(costs, target - costs[i], i, path, ans);

            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

        // N Queens
        List<List<String>> queens = solveNQueens(4);

        System.out.println("N-Queens Solutions:");
        for (List<String> board : queens) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }

        // Permutations
        System.out.println("Permutations of ABC:");
        System.out.println(permutations("ABC"));

        // Subsets
        String[] items = {"Laptop", "Mouse", "Keyboard"};

        System.out.println("Subsets of inventory:");
        System.out.println(subsets(items));

        // Combination Sum
        int[] costs = {2, 3, 6, 7};
        int target = 7;

        System.out.println("Combinations with target budget 7:");
        System.out.println(combinationSum(costs, target));
    }
}
