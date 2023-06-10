package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BalancedBinaryTreeTest {

    @Test
    void isBalanced() {

        TreeNode<Integer> root = new TreeNode<>();
        root.val = 3;
        root.right = new TreeNode<>();
        root.right.val = 20;
        root.right.right = new TreeNode<>();
        root.right.right.val = 7;
        root.right.left = new TreeNode<>();
        root.right.left.val = 15;

        root.left = new TreeNode<>();
        root.left.val = 9;

        Assertions.assertTrue(BalancedBinaryTree.isBalanced(root));
        Assertions.assertTrue(BalancedBinaryTree.isBalanced(null));
        Assertions.assertTrue(BalancedBinaryTree.isBalanced(new TreeNode<>()));
        Assertions.assertTrue(BalancedBinaryTree.isBalanced(new TreeNode<>()));

        root.left.left = new TreeNode<>();
        root.left.left.left = new TreeNode<>();
        Assertions.assertFalse(BalancedBinaryTree.isBalanced(root));
    }

}