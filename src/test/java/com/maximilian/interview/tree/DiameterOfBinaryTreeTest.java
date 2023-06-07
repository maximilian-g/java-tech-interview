package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DiameterOfBinaryTreeTest {

    @Test
    void diameterOfBinaryTree() {
        TreeNode<Integer> root = new TreeNode<>();
        root.val = 1;
        root.right = new TreeNode<>();
        root.right.val = 3;
        root.left = new TreeNode<>();
        root.left.val = 2;
        root.left.left = new TreeNode<>();
        root.left.left.val = 4;
        root.left.right = new TreeNode<>();
        root.left.right.val = 5;

        Assertions.assertEquals(3, DiameterOfBinaryTree.diameterOfBinaryTree(root));

    }

}