import java.util.*;

public class EmployeeAttendanceRanking {

    static int[] topKEmployees(int[] employeeIds, int[] attendance, int k) {
        Integer[] index = new Integer[employeeIds.length];

        for (int i = 0; i < employeeIds.length; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (a, b) -> {
            if (attendance[a] != attendance[b]) {
                return attendance[b] - attendance[a];
            }
            return employeeIds[a] - employeeIds[b];
        });

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = employeeIds[index[i]];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] employeeIds = {101, 102, 103, 104, 105};
        int[] attendance = {92, 85, 98, 92, 80};
        int k = 3;

        int[] ans = topKEmployees(employeeIds, attendance, k);

        System.out.println(Arrays.toString(ans));
    }
}
