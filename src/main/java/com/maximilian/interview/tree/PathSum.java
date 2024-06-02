package com.maximilian.interview.tree;

public class PathSum {

    public static boolean hasPathSum(TreeNode<Integer> root, int targetSum) {
        if (root == null) {
            return false;
        }
        int diff = targetSum - root.val;
        // left
        if (hasPathSum(root.left, diff)) {
            return true;
        }
        // right
        if (hasPathSum(root.right, diff)) {
            return true;
        }
        // ensuring that we are working with leaf
        return diff == 0 && root.left == null && root.right == null;
    }

}
