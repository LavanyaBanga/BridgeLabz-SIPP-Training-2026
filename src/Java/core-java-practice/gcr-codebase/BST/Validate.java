public class ValidateBST {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    static boolean isValidBST(Node root) {
        return validate(
            root,
            Long.MIN_VALUE,
            Long.MAX_VALUE
        );
    }

    static boolean validate(Node root, long minimum, long maximum) {
        if (root == null) {
            return true;
        }

        if (root.value <= minimum || root.value >= maximum) {
            return false;
        }

        boolean isLeftSubtreeValid = validate(
            root.left,
            minimum,
            root.value
        );

        boolean isRightSubtreeValid = validate(
            root.right,
            root.value,
            maximum
        );

        return isLeftSubtreeValid && isRightSubtreeValid;
    }

    public static void main(String[] args) {

        /*
                  50
                 /  \
               30    70
              / \    / \
             20 40  60 80
        */

        Node validRoot = new Node(50);
        validRoot.left = new Node(30);
        validRoot.right = new Node(70);
        validRoot.left.left = new Node(20);
        validRoot.left.right = new Node(40);
        validRoot.right.left = new Node(60);
        validRoot.right.right = new Node(80);

        System.out.println(
            "First tree is valid BST: "
            + isValidBST(validRoot)
        );

        /*
                  10
                 /  \
                5    15
                 \
                  12

            12 is greater than 10 but is present
            inside the left subtree of 10.
        */

        Node invalidRoot = new Node(10);
        invalidRoot.left = new Node(5);
        invalidRoot.right = new Node(15);
        invalidRoot.left.right = new Node(12);

        System.out.println(
            "Second tree is valid BST: "
            + isValidBST(invalidRoot)
        );
    }
}
