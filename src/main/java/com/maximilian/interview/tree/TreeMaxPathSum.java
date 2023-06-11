package com.maximilian.interview.tree;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes
 * in the sequence has an edge connecting them. A node can only appear in the sequence at most once.
 * Note that the path does not need to pass through the root.
 * <p>
 * The path sum of a path is the sum of the node's values in the path.
 * <p>
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
public class TreeMaxPathSum {

    // not thread safe
    private static int maxPathSum;

    public static int maxPathSum(TreeNode<Integer> root) {
        maxPathSum = Integer.MIN_VALUE;
        maxPathSumInternal(root);
        return maxPathSum;
    }

    private static int maxPathSumInternal(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(0, maxPathSumInternal(root.left));
        int rightSum = Math.max(0, maxPathSumInternal(root.right));

        maxPathSum = Math.max(leftSum + root.val + rightSum, maxPathSum);

        return root.val + Math.max(leftSum, rightSum);
    }

}
