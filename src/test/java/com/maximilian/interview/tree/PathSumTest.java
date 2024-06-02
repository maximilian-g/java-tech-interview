package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PathSumTest {

    @Test
    void hasPathSum() {
        TreeNode<Integer> root = new TreeNode<>(1);
        int target = 1;
        Assertions.assertTrue(PathSum.hasPathSum(root, target));
        Assertions.assertFalse(PathSum.hasPathSum(null, target));
        Assertions.assertFalse(PathSum.hasPathSum(null, 0));

        root = new TreeNode<>(1, new TreeNode<>(2), new TreeNode<>(3));
        target = 5;
        Assertions.assertFalse(PathSum.hasPathSum(root, target));
        target = 4;
        Assertions.assertTrue(PathSum.hasPathSum(root, target));
    }

}