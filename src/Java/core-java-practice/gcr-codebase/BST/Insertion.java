public class BSTInsertion {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    static Node insert(Node root, int employeeId) {
        if (root == null) {
            return new Node(employeeId);
        }

        if (employeeId < root.value) {
            root.left = insert(root.left, employeeId);
        } else if (employeeId > root.value) {
            root.right = insert(root.right, employeeId);
        }

        // Duplicate values are ignored
        return root;
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

        int[] employeeIds = {50, 30, 70, 20, 40, 60, 80};

        for (int employeeId : employeeIds) {
            root = insert(root, employeeId);
        }

        System.out.println("Employee IDs in sorted order:");
        inorderTraversal(root);
    }
}
