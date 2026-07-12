public class CpuSpikeDetection {

    public static int maxSubarrayOfSizeK(
            int[] cpuLoad, int windowSize) {

        if (cpuLoad == null
                || windowSize <= 0
                || windowSize > cpuLoad.length) {

            throw new IllegalArgumentException(
                "Invalid window size"
            );
        }

        int windowSum = 0;
        int maximumSum = Integer.MIN_VALUE;
        int windowStart = 0;

        for (int windowEnd = 0;
             windowEnd < cpuLoad.length;
             windowEnd++) {

            windowSum += cpuLoad[windowEnd];

            if (windowEnd >= windowSize - 1) {
                maximumSum = Math.max(
                    maximumSum,
                    windowSum
                );

                windowSum -= cpuLoad[windowStart];
                windowStart++;
            }
        }

        return maximumSum;
    }

    public static void main(String[] args) {
        int[] cpuLoad = {
            10, 20, 30, 40, 50, 25
        };

        int windowSize = 3;

        int maximumLoad =
            maxSubarrayOfSizeK(cpuLoad, windowSize);

        System.out.println(
            "Maximum CPU load in a "
            + windowSize
            + "-second window: "
            + maximumLoad
        );
    }
}
