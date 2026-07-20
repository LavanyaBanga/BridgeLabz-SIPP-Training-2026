public class LowestCommonAncestorBST {

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

    static Node lowestCommonAncestor(
        Node root,
        int firstValue,
        int secondValue
    ) {
        Node current = root;

        while (current != null) {

            // Both values are in the left subtree
            if (
                firstValue < current.value
                && secondValue < current.value
            ) {
                current = current.left;
            }

            // Both values are in the right subtree
            else if (
                firstValue > current.value
                && secondValue > current.value
            ) {
                current = current.right;
            }

            // Values split here, or current is one target
            else {
                return current;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Node root = null;

        int[] departmentCodes = {
            50, 30, 70, 20, 40, 60, 80
        };

        for (int departmentCode : departmentCodes) {
            root = insert(root, departmentCode);
        }

        int firstDepartment = 20;
        int secondDepartment = 40;

        Node ancestor = lowestCommonAncestor(
            root,
            firstDepartment,
            secondDepartment
        );

        System.out.println(
            "LCA of "
            + firstDepartment
            + " and "
            + secondDepartment
            + " is: "
            + ancestor.value
        );

        firstDepartment = 20;
        secondDepartment = 80;

        ancestor = lowestCommonAncestor(
            root,
            firstDepartment,
            secondDepartment
        );

        System.out.println(
            "LCA of "
            + firstDepartment
            + " and "
            + secondDepartment
            + " is: "
            + ancestor.value
        );
    }
}
