package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxTreeDepthTest {

    @Test
    void calculateDepth() {
        TreeNode<Integer> root = new TreeNode<>();
        root.val = 10;
        root.left = new TreeNode<>();
        root.left.val = 5;
        root.right = new TreeNode<>();
        root.right.val = 15;

        Assertions.assertEquals(0, MaxTreeDepth.calculateDepth(null));
        Assertions.assertEquals(1, MaxTreeDepth.calculateDepth(new TreeNode<>()));
        Assertions.assertEquals(2, MaxTreeDepth.calculateDepth(root));
        root.right.right = new TreeNode<>();
        root.right.right.val = 30;
        Assertions.assertEquals(3, MaxTreeDepth.calculateDepth(root));

    }

}