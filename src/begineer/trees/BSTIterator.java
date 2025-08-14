package begineer.trees;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        // Push all leftmost nodes onto the stack
        pushAllLeft(root);
    }

    public int next() {
        TreeNode current = stack.pop();
        // If node has right child, push all left nodes in its right subtree
        pushAllLeft(current.right);
        return current.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Construct the BST as shown in the image
        // 7
        // / \
        // 3 15
        // / \
        // 9 20

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        System.out.println("Inorder traversal of BST:");
        BSTIterator iterator = new BSTIterator(root);

        System.out.println("hasNext(): " + iterator.hasNext()); // Should be true

        System.out.println("next(): " + iterator.next()); // Should return 3
        System.out.println("next(): " + iterator.next()); // Should return 7
        System.out.println("next(): " + iterator.next()); // Should return 9
        System.out.println("next(): " + iterator.next()); // Should return 15
        System.out.println("next(): " + iterator.next()); // Should return 20

        System.out.println("hasNext(): " + iterator.hasNext()); // Should be false
    }
}
