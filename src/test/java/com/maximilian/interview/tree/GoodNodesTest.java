package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GoodNodesTest {

    @Test
    void goodNodes() {

        TreeNode<Integer> root = new TreeNode<>();
        root.val = 3;
        root.right = new TreeNode<>();
        root.right.val = 4;
        root.right.right = new TreeNode<>();
        root.right.right.val = 5;
        root.right.left = new TreeNode<>();
        root.right.left.val = 1;

        root.left = new TreeNode<>();
        root.left.val = 1;
        root.left.left = new TreeNode<>();
        root.left.left.val = 3;

        Assertions.assertEquals(4, GoodNodes.goodNodes(root));

    }

}