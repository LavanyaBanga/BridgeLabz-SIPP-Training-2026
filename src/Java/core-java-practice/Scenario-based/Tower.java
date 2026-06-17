public static int moves = 0;

public static void Tower(int n, char src, char helper, char dest) {

    if (n == 1) {
        System.out.println("Move disk 1 from " + src + " to " + dest);
        moves++;
        return;
    }

    towerOfHanoi(n - 1, src, dest, helper);

    System.out.println("Move disk " + n + " from " + src + " to " + dest);
    moves++;

    towerOfHanoi(n - 1, helper, src, dest);
}