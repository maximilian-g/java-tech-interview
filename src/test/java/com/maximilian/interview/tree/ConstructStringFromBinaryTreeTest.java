package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstructStringFromBinaryTreeTest {

    @Test
    void tree2str() {
        TreeNode<Integer> root = new TreeNode<>(
                1,
                new TreeNode<>(2, new TreeNode<>(4), null),
                new TreeNode<>(3)
        );
        String expected = "1(2(4))(3)";
        Assertions.assertEquals(expected, ConstructStringFromBinaryTree.tree2str(root));

        root = new TreeNode<>(
                1,
                new TreeNode<>(2, null, new TreeNode<>(4)),
                new TreeNode<>(3)
        );
        expected = "1(2()(4))(3)";
        Assertions.assertEquals(expected, ConstructStringFromBinaryTree.tree2str(root));
    }

}