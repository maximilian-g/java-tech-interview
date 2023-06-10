package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidateBinarySearchTreeTest {

    @Test
    void isValidBST() {
        TreeNode<Integer> root = new TreeNode<>();
        root.val = 2;
        root.left = new TreeNode<>();
        root.left.val = 1;
        root.right = new TreeNode<>();
        root.right.val = 3;

        Assertions.assertTrue(ValidateBinarySearchTree.isValidBST(root));
        root.right.val = -5;
        Assertions.assertFalse(ValidateBinarySearchTree.isValidBST(root));

    }

}