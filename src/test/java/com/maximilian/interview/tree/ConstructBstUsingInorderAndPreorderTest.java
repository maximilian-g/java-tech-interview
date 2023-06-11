package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstructBstUsingInorderAndPreorderTest {

    @Test
    void buildTree() {

        TreeNode<Integer> expectedRoot = new TreeNode<>(
                3,
                new TreeNode<>(9),
                new TreeNode<>(20, new TreeNode<>(15), new TreeNode<>(7))
        );

        TreeNode<Integer> res = ConstructBstUsingInorderAndPreorder.buildTree(
                new int[]{3, 9, 20, 15, 7},
                new int[]{9, 3, 15, 20, 7}
        );

        Assertions.assertTrue(SameTree.isSameTree(expectedRoot, res));

    }

}