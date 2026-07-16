class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class TreeHeight {

    // Function to calculate height of tree
    public static int height(Node node) {

        if (node == null) {
            return -1;   // Edge-counting convention
        }

        return Math.max(height(node.left), height(node.right)) + 1;
    }

    // Check if tree height exceeds threshold
    public static boolean isTooDeep(Node root, int threshold) {
        return height(root) > threshold;
    }

    public static void main(String[] args) {

        // Creating Tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(5);

        int threshold = 2;

        int h = height(root);

        System.out.println("Tree Height: " + h);

        if (isTooDeep(root, threshold)) {
            System.out.println("Tree exceeds the threshold.");
        } else {
            System.out.println("Tree is within the threshold.");
        }
    }
}
