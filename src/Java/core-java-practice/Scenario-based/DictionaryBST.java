import java.util.*;

public class DictionaryBST {

    static class Node {
        String word;
        Node left, right;

        Node(String word) {
            this.word = word;
        }
    }

    Node root;

    // 1. Insert word
    Node insert(Node root, String word) {
        if (root == null) {
            return new Node(word);
        }

        if (word.compareTo(root.word) < 0) {
            root.left = insert(root.left, word);
        } else if (word.compareTo(root.word) > 0) {
            root.right = insert(root.right, word);
        }

        return root;
    }

    // 2. Search word
    boolean search(Node root, String word) {
        if (root == null) return false;

        if (root.word.equals(word)) return true;

        if (word.compareTo(root.word) < 0) {
            return search(root.left, word);
        } else {
            return search(root.right, word);
        }
    }

    // 3. Delete word
    Node delete(Node root, String word) {
        if (root == null) return null;

        if (word.compareTo(root.word) < 0) {
            root.left = delete(root.left, word);
        } else if (word.compareTo(root.word) > 0) {
            root.right = delete(root.right, word);
        } else {

            // Case 1: no child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: one child
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // Case 3: two children
            Node successor = findMin(root.right);
            root.word = successor.word;
            root.right = delete(root.right, successor.word);
        }

        return root;
    }

    Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // 4. kth alphabetically using inorder
    int count = 0;
    String kthAnswer = null;

    String kthWord(Node root, int k) {
        count = 0;
        kthAnswer = null;
        inorderK(root, k);
        return kthAnswer;
    }

    void inorderK(Node root, int k) {
        if (root == null) return;

        inorderK(root.left, k);

        count++;
        if (count == k) {
            kthAnswer = root.word;
            return;
        }

        inorderK(root.right, k);
    }

    // 5. Validate BST
    boolean validateBST(Node root) {
        return validate(root, null, null);
    }

    boolean validate(Node root, String min, String max) {
        if (root == null) return true;

        if (min != null && root.word.compareTo(min) <= 0) return false;
        if (max != null && root.word.compareTo(max) >= 0) return false;

        return validate(root.left, min, root.word) &&
               validate(root.right, root.word, max);
    }

    // 6. Lowest Common Ancestor
    Node lca(Node root, String w1, String w2) {
        if (root == null) return null;

        if (w1.compareTo(root.word) < 0 && w2.compareTo(root.word) < 0) {
            return lca(root.left, w1, w2);
        }

        if (w1.compareTo(root.word) > 0 && w2.compareTo(root.word) > 0) {
            return lca(root.right, w1, w2);
        }

        return root;
    }

    // Print words alphabetically
    void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.word + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        DictionaryBST bst = new DictionaryBST();

        String[] words = {
                "mango", "apple", "banana", "grape", "orange",
                "peach", "cherry", "kiwi", "lemon", "melon",
                "papaya", "fig", "date", "berry", "plum",
                "pear", "guava", "apricot", "coconut", "lime"
        };

        for (String word : words) {
            bst.root = bst.insert(bst.root, word);
        }

        System.out.println("Words in alphabetical order:");
        bst.inorder(bst.root);

        System.out.println("\n\nSearch apple: " + bst.search(bst.root, "apple"));
        System.out.println("Search strawberry: " + bst.search(bst.root, "strawberry"));

        System.out.println("\n3rd word alphabetically: " + bst.kthWord(bst.root, 3));

        System.out.println("Valid BST: " + bst.validateBST(bst.root));

        Node ancestor = bst.lca(bst.root, "apple", "kiwi");
        System.out.println("LCA of apple and kiwi: " + ancestor.word);

        // Delete Case 1, 2, 3 examples
        bst.root = bst.delete(bst.root, "lime");   // leaf node
        bst.root = bst.delete(bst.root, "peach");  // one child possible
        bst.root = bst.delete(bst.root, "mango");  // two children

        System.out.println("\nAfter deletions:");
        bst.inorder(bst.root);
    }
}
