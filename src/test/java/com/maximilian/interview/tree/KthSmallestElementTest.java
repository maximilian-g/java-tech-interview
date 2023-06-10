package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KthSmallestElementTest {

    @Test
    void kthSmallest() {

        TreeNode<Integer> root = new TreeNode<>();
        root.val = 2;
        root.left = new TreeNode<>();
        root.left.val = 1;
        root.right = new TreeNode<>();
        root.right.val = 3;

        Assertions.assertEquals(1, KthSmallestElement.kthSmallest(root, 1));
        Assertions.assertEquals(2, KthSmallestElement.kthSmallest(root, 2));
        Assertions.assertEquals(3, KthSmallestElement.kthSmallest(root, 3));

    }

}