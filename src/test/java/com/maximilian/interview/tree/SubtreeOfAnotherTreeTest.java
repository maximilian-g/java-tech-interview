package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SubtreeOfAnotherTreeTest {

    @Test
    void isSubtree() {

        TreeNode<Integer> root = new TreeNode<>();
        root.val = 3;
        root.right = new TreeNode<>();
        root.right.val = 5;
        root.left = new TreeNode<>();
        root.left.val = 4;
        root.left.right = new TreeNode<>();
        root.left.right.val = 2;
        root.left.left = new TreeNode<>();
        root.left.left.val = 1;

        TreeNode<Integer> subTree = root.left;

        Assertions.assertTrue(SubtreeOfAnotherTree.isSubtree(root, subTree));

        TreeNode<Integer> temp = new TreeNode<>();
        temp.val = 44;
        Assertions.assertFalse(SubtreeOfAnotherTree.isSubtree(root, temp));

    }

}