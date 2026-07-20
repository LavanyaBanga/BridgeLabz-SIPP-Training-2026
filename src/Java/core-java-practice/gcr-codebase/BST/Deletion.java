public class BSTDeletion {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.value) {
            root.left = insert(root.left, value);
        } else if (value > root.value) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    static Node delete(Node root, int valueToDelete) {
        if (root == null) {
            return null;
        }

        if (valueToDelete < root.value) {
            root.left = delete(root.left, valueToDelete);
        } else if (valueToDelete > root.value) {
            root.right = delete(root.right, valueToDelete);
        } else {

            // Case 1: Leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Only right child
            if (root.left == null) {
                return root.right;
            }

            // Case 2: Only left child
            if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            Node inorderSuccessor = findMinimum(root.right);

            root.value = inorderSuccessor.value;

            root.right = delete(
                root.right,
                inorderSuccessor.value
            );
        }

        return root;
    }

    static Node findMinimum(Node root) {
        Node current = root;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.value + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        Node root = null;

        int[] values = {50, 30, 70, 20, 40, 60, 80};

        for (int value : values) {
            root = insert(root, value);
        }

        System.out.println("Original BST:");
        inorderTraversal(root);

        // Delete leaf node
        root = delete(root, 20);
        System.out.println("\n\nAfter deleting leaf node 20:");
        inorderTraversal(root);

        // Node 30 now has only one child: 40
        root = delete(root, 30);
        System.out.println("\n\nAfter deleting node 30 with one child:");
        inorderTraversal(root);

        // Root 50 has two children
        root = delete(root, 50);
        System.out.println("\n\nAfter deleting node 50 with two children:");
        inorderTraversal(root);
    }
}
