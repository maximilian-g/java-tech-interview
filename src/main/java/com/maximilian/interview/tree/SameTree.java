package com.maximilian.interview.tree;

import java.util.Objects;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical,
 * and the nodes have the same value.
 */
public class SameTree {

    public static boolean isSameTree(TreeNode<Integer> p, TreeNode<Integer> q) {
        return areSame(p, q);
    }

    private static boolean areSame(TreeNode<Integer> p, TreeNode<Integer> q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return Objects.equals(p.val, q.val) && areSame(p.left, q.left) && areSame(p.right, q.right);
    }

}
