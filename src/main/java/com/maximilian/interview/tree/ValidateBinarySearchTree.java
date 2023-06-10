package com.maximilian.interview.tree;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 * <p>
 * The left
 * subtree
 * of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {

    public static boolean isValidBST(TreeNode<Integer> root) {
        // all that is left from root must be < root.val,
        // all that is right from root must be > root.val
        if (root.left != null) {
            if (root.val <= root.left.val || !isValidBST(root.left)) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.val >= root.right.val || !isValidBST(root.right)) {
                return false;
            }
        }
        return true;
    }

}
