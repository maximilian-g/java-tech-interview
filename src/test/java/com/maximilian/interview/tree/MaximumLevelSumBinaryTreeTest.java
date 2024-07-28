package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumLevelSumBinaryTreeTest {

    @Test
    void maxLevelSum() {

        TreeNode<Integer> root = new TreeNode<>(1,
                new TreeNode<>(7, new TreeNode<>(7), new TreeNode<>(-8)),
                new TreeNode<>(0));

        Assertions.assertEquals(2, MaximumLevelSumBinaryTree.maxLevelSum(root));

    }

}