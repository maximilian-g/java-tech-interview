package com.maximilian.interview.tree;

import java.util.Stack;
import java.util.function.Predicate;

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


    public static boolean isValidBSTStack(TreeNode<Integer> root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }

    public static boolean isValidBST(TreeNode<Integer> root) {
        return isValidBSTInternal(root, null);
    }

    public static boolean isValidBSTInternal(TreeNode<Integer> root, Predicate<Integer> compliesWithParent) {
        if (root == null) {
            return true;
        }
        // all that is left from root must be < root.val,
        // all that is right from root must be > root.val
        if (root.left != null) {
            if (root.val <= root.left.val ||
                    !isValidBSTInternal(root.left, (val -> root.val > val && (compliesWithParent == null || compliesWithParent.test(val))))) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.val >= root.right.val ||
                    !isValidBSTInternal(root.right, (val -> root.val < val && (compliesWithParent == null || compliesWithParent.test(val))))) {
                return false;
            }
        }
        return compliesWithParent == null || compliesWithParent.test(root.val);
    }

}
