package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidateBinarySearchTreeTest {

    @Test
    void isValidBST() {
        TreeNode<Integer> root = new TreeNode<>(2);
        root.left = new TreeNode<>(1);
        root.right = new TreeNode<>(3);

        Assertions.assertTrue(ValidateBinarySearchTree.isValidBSTStack(root));
        Assertions.assertTrue(ValidateBinarySearchTree.isValidBST(root));
        root.right.val = -5;
        Assertions.assertFalse(ValidateBinarySearchTree.isValidBSTStack(root));
        Assertions.assertFalse(ValidateBinarySearchTree.isValidBST(root));

        root = new TreeNode<>(5);
        root.left = new TreeNode<>(4);
        root.right = new TreeNode<>(6, new TreeNode<>(3), new TreeNode<>(7));
        Assertions.assertFalse(ValidateBinarySearchTree.isValidBSTStack(root));
        Assertions.assertFalse(ValidateBinarySearchTree.isValidBST(root));

    }

}