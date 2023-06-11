package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TreeMaxPathSumTest {

    @Test
    void maxPathSum() {

        TreeNode<Integer> root = new TreeNode<>(2, new TreeNode<>(1), new TreeNode<>(3));

        Assertions.assertEquals(6, TreeMaxPathSum.maxPathSum(root));

        root = new TreeNode<>(-10,
                new TreeNode<>(9),
                new TreeNode<>(20, new TreeNode<>(15), new TreeNode<>(7)));
        Assertions.assertEquals(42, TreeMaxPathSum.maxPathSum(root));

    }

}