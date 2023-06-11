package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LowestCommonAncestorTest {

    @Test
    void lowestCommonAncestor() {

        TreeNode<Integer> root = new TreeNode<>();
        root.val = 6;
        root.right = new TreeNode<>();
        root.right.val = 8;
        root.right.right = new TreeNode<>();
        root.right.right.val = 9;
        root.right.left = new TreeNode<>();
        root.right.left.val = 7;

        root.left = new TreeNode<>();
        root.left.val = 2;
        root.left.left = new TreeNode<>();
        root.left.left.val = 0;
        root.left.right = new TreeNode<>();
        root.left.right.val = 4;
        root.left.right.right = new TreeNode<>();
        root.left.right.right.val = 5;
        root.left.right.left = new TreeNode<>();
        root.left.right.left.val = 3;

        Assertions.assertEquals(root, LowestCommonAncestor.lowestCommonAncestor(root, root.left, root.right));

    }

}