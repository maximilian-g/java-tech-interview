package com.maximilian.interview.tree;


/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes
 * along the longest path from the root node down to the farthest leaf node.
 */
public class MaxTreeDepth {

    private static final ThreadLocal<Integer> depth = new ThreadLocal<>();

    public static <T> int calculateDepth(TreeNode<T> root) {
        depth.set(0);
        traverseAccumulatingDepth(root, depth.get());
        return depth.get();
    }

    private static <T> void traverseAccumulatingDepth(TreeNode<T> node, int currentDepth) {
        if(node == null) {
            return;
        }
        // current node is not null, depth = depth + 1
        currentDepth += 1;
        traverseAccumulatingDepth(node.left, currentDepth);
        traverseAccumulatingDepth(node.right, currentDepth);
        depth.set(Math.max(depth.get(), currentDepth));
    }

}
