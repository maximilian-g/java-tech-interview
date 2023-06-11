package com.maximilian.interview.tree;

/**
 * Given a binary tree root, a node X in the tree is named good
 * if in the path from root to X there are no nodes with a value greater than X.
 * <p>
 * Return the number of good nodes in the binary tree.
 */
public class GoodNodes {

    public static int goodNodes(TreeNode<Integer> root) {
        return traverse(root, Integer.MIN_VALUE);
    }

    private static int traverse(TreeNode<Integer> root, int max) {
        if (root == null) {
            return 0;
        }

        int res = root.val >= max ? 1 : 0;

        max = Math.max(max, root.val);

        res += traverse(root.left, max);
        res += traverse(root.right, max);

        return res;
    }

}
