package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InsertIntoBSTTest {

    @Test
    void insertIntoBST() {

        TreeNode<Integer> test = new TreeNode<>(4,
                new TreeNode<>(2, new TreeNode<>(1), new TreeNode<>(3)),
                new TreeNode<>(7));

        TreeNode<Integer> result = InsertIntoBST.insertIntoBST(test, 5);
        Assertions.assertTrue(hasValue(result, 5) && isBinarySearchTree(result));

    }

    private static boolean hasValue(TreeNode<Integer> root, int val) {
        if (root.val == val) {
            return true;
        }
        if (root.val > val) {
            return hasValue(root.left, val);
        }
        return hasValue(root.right, val);
    }

    private static boolean isBinarySearchTree(TreeNode<Integer> root) {
        return (root.left == null || (root.left.val < root.val && isBinarySearchTree(root.left))) &&
                (root.right == null || (root.right.val > root.val && isBinarySearchTree(root.right)));
    }

}