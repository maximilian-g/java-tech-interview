package com.maximilian.interview.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given the root of a binary search tree, and an integer k,
 * return the kth the smallest value (1-indexed) of all the values of the nodes in the tree.
 */
public class KthSmallestElement {

    // O(n)
    public static int kthSmallest(TreeNode<Integer> root, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        fillQueueFromSmallest(root, queue);
        return queue.stream().skip(k - 1).findFirst().orElseThrow();
    }

    private static void fillQueueFromSmallest(TreeNode<Integer> root, Queue<Integer> queue) {
        if (root == null) {
            return;
        }
        fillQueueFromSmallest(root.left, queue);
        queue.add(root.val);
        fillQueueFromSmallest(root.right, queue);
    }

}
