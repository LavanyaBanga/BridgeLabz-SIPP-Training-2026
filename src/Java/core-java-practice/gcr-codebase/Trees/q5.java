class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class TreeDiameter {

    static int diameter = 0;

    // Function to find longest communication path
    public static int longestCommunicationPath(Node root) {
        diameter = 0;
        heightAndUpdateDiameter(root);
        return diameter;
    }

    // Height calculation + Diameter update
    public static int heightAndUpdateDiameter(Node node) {

        if (node == null) {
            return -1;      // Edge-counting convention
        }

        int leftHeight = heightAndUpdateDiameter(node.left);
        int rightHeight = heightAndUpdateDiameter(node.right);

        // Update diameter
        diameter = Math.max(diameter, leftHeight + rightHeight + 2);

        // Return height
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {

        // Creating Tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);

        int result = longestCommunicationPath(root);

        System.out.println("Diameter of Tree: " + result);
    }
}
