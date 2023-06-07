package com.maximilian.interview.tree;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * <p>
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * <p>
 * The length of a path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {

    private static final ThreadLocal<Integer> diameter = new ThreadLocal<>();

    public static <T> int diameterOfBinaryTree(TreeNode<T> root) {
        diameter.set(0);
        calculateDiameter(root);
        return diameter.get();
    }

    private static <T> int calculateDiameter(TreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = calculateDiameter(root.left);
        int rightHeight = calculateDiameter(root.right);

        diameter.set(Math.max(diameter.get(), leftHeight + rightHeight));

        return Math.max(leftHeight, rightHeight) + 1;
    }

}
