package com.maximilian.interview.tree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * A height-balanced binary tree is a binary tree in which
 * the depth of the two subtrees of every node never differs by more than one.
 */
public class BalancedBinaryTree {

    // O(n)
    public static <T> boolean isBalanced(TreeNode<T> root) {
        return dfs(root).balanced;
    }

    private static <T> TreeInfo dfs(TreeNode<T> root) {
        if (root == null) {
            return new TreeInfo(0, true);
        }

        TreeInfo left = dfs(root.left);
        TreeInfo right = dfs(root.right);

        return new TreeInfo(1 + Math.max(left.maxDepth, right.maxDepth),
                left.balanced && right.balanced &&
                        Math.abs(left.maxDepth - right.maxDepth) <= 1);
    }

    private static class TreeInfo {
        int maxDepth;
        boolean balanced;

        public TreeInfo(int maxDepth, boolean balanced) {
            this.maxDepth = maxDepth;
            this.balanced = balanced;
        }

    }

}
