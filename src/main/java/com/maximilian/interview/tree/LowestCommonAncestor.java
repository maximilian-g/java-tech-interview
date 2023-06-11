package com.maximilian.interview.tree;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA)
 * node of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestor {

    public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root,
                                                         TreeNode<Integer> p, TreeNode<Integer> q) {
        // case when both are on right side of tree
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(
                    root.right,
                    p,
                    q
            );
        }
        // case when both are on left side of tree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(
                    root.left,
                    p,
                    q
            );
        }
        // case when p or q are on different sides(left and right),
        // so we found lowest ancestor of p and q
        return root;
    }

}
