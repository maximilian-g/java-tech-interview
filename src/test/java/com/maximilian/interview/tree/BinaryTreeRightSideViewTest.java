package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class BinaryTreeRightSideViewTest {

    @Test
    void rightSideView() {

        TreeNode<Integer> root = new TreeNode<>();
        root.val = 1;
        root.right = new TreeNode<>();
        root.right.val = 3;
        root.right.right = new TreeNode<>();
        root.right.right.val = 4;

        root.left = new TreeNode<>();
        root.left.val = 2;
        root.left.right = new TreeNode<>();
        root.left.right.val = 5;

        List<Integer> res = BinaryTreeRightSideView.rightSideView(root);
        List<Integer> expected = List.of(1, 3, 4);

        Assertions.assertEquals(expected.size(), res.size());

        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), res.get(i));
        }

    }

}