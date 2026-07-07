import java.util.*;

public class FamilyTree {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // 1. Recursive Traversals
    static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }
    }

    // 2. Iterative Preorder
    static void iterativePreorder(Node root) {
        if (root == null) return;

        Stack<Node> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            Node curr = st.pop();
            System.out.print(curr.data + " ");

            if (curr.right != null) st.push(curr.right);
            if (curr.left != null) st.push(curr.left);
        }
    }

    // 3. Iterative Inorder
    static void iterativeInorder(Node root) {
        Stack<Node> st = new Stack<>();
        Node curr = root;

        while (curr != null || !st.isEmpty()) {

            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            System.out.print(curr.data + " ");

            curr = curr.right;
        }
    }

    // 4. Iterative Postorder using 2 stacks
    static void iterativePostorder(Node root) {
        if (root == null) return;

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.push(root);

        while (!st1.isEmpty()) {
            Node curr = st1.pop();
            st2.push(curr);

            if (curr.left != null) st1.push(curr.left);
            if (curr.right != null) st1.push(curr.right);
        }

        while (!st2.isEmpty()) {
            System.out.print(st2.pop().data + " ");
        }
    }

    // 5. Height of tree
    static int height(Node root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 6. Count nodes at each level
    static void countNodesEachLevel(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            System.out.println("Level " + level + " has " + size + " nodes");

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }

            level++;
        }
    }

    // 7. Diameter of tree
    static int diameter(Node root) {
        if (root == null) return 0;

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        int throughRoot = height(root.left) + height(root.right) + 1;

        return Math.max(throughRoot, Math.max(leftDiameter, rightDiameter));
    }

    // 8. Optimized Diameter O(n)
    static class DiaPair {
        int height;
        int diameter;

        DiaPair(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    static DiaPair diameterOptimized(Node root) {
        if (root == null) {
            return new DiaPair(0, 0);
        }

        DiaPair left = diameterOptimized(root.left);
        DiaPair right = diameterOptimized(root.right);

        int height = Math.max(left.height, right.height) + 1;

        int diameter = Math.max(
                left.height + right.height + 1,
                Math.max(left.diameter, right.diameter)
        );

        return new DiaPair(height, diameter);
    }

    // 9. Check Balanced Tree
    static boolean isBalanced(Node root) {
        if (root == null) return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    // 10. Optimized Balanced Check O(n)
    static int checkBalanced(Node root) {
        if (root == null) return 0;

        int left = checkBalanced(root.left);
        if (left == -1) return -1;

        int right = checkBalanced(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }

    static boolean isBalancedOptimized(Node root) {
        return checkBalanced(root) != -1;
    }

    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Recursive Preorder:");
        preorder(root);

        System.out.println("\nRecursive Inorder:");
        inorder(root);

        System.out.println("\nRecursive Postorder:");
        postorder(root);

        System.out.println("\nLevel Order:");
        levelOrder(root);

        System.out.println("\n\nIterative Preorder:");
        iterativePreorder(root);

        System.out.println("\nIterative Inorder:");
        iterativeInorder(root);

        System.out.println("\nIterative Postorder:");
        iterativePostorder(root);

        System.out.println("\n\nHeight: " + height(root));

        System.out.println("\nNodes at each level:");
        countNodesEachLevel(root);

        System.out.println("\nDiameter: " + diameter(root));
        System.out.println("Optimized Diameter: " + diameterOptimized(root).diameter);

        System.out.println("Balanced: " + isBalanced(root));
        System.out.println("Balanced Optimized: " + isBalancedOptimized(root));
    }
}
