package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SameTreeTest {

    @Test
    void isSameTree() {

        TreeNode<Integer> firstRoot = getTestTree();
        TreeNode<Integer> secondRoot = getTestTree();

        Assertions.assertTrue(SameTree.isSameTree(firstRoot, secondRoot));
        firstRoot.right = null;
        Assertions.assertFalse(SameTree.isSameTree(firstRoot, secondRoot));
        Assertions.assertFalse(SameTree.isSameTree(firstRoot, null));
        Assertions.assertFalse(SameTree.isSameTree(null, firstRoot));

    }

    private TreeNode<Integer> getTestTree() {
        TreeNode<Integer> root = new TreeNode<>();
        root.val = 1;
        root.right = new TreeNode<>();
        root.right.val = 3;
        root.left = new TreeNode<>();
        root.left.val = 2;
        return root;
    }

}