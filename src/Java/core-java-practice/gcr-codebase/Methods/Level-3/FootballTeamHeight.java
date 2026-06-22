public class FootballTeamHeight {
    public static int sum(int[] heights) {
        int s = 0;
        for (int h : heights) s += h;
        return s;
    }

    public static double mean(int[] heights) {
        return (double) sum(heights) / heights.length;
    }

    public static int shortest(int[] heights) {
        int min = heights[0];
        for (int h : heights) min = Math.min(min, h);
        return min;
    }

    public static int tallest(int[] heights) {
        int max = heights[0];
        for (int h : heights) max = Math.max(max, h);
        return max;
    }

    public static void main(String[] args) {
        int[] heights = new int[11];

        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + (int)(Math.random() * 101);
            System.out.println("Player " + (i + 1) + " height: " + heights[i]);
        }

        System.out.println("Shortest Height = " + shortest(heights));
        System.out.println("Tallest Height = " + tallest(heights));
        System.out.println("Mean Height = " + mean(heights));
    }
}