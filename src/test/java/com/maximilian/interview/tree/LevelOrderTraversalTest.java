package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LevelOrderTraversalTest {

    @Test
    void levelOrder() {

        TreeNode<Integer> root = new TreeNode<>();
        root.val = 3;
        root.right = new TreeNode<>();
        root.right.val = 20;
        root.right.right = new TreeNode<>();
        root.right.right.val = 7;
        root.right.left = new TreeNode<>();
        root.right.left.val = 15;

        root.left = new TreeNode<>();
        root.left.val = 9;

        List<List<Integer>> res = LevelOrderTraversal.levelOrder(root);
        List<List<Integer>> expected = List.of(
                List.of(3),
                List.of(9, 20),
                List.of(15, 7)
        );

        Assertions.assertEquals(expected.size(), res.size());
        for (int i = 0; i < expected.size(); i++) {
            List<Integer> levelElement = expected.get(i);
            List<Integer> levelElementRes = res.get(i);
            Assertions.assertEquals(levelElement.size(), levelElementRes.size());
            for (int j = 0; j < levelElement.size(); j++) {
                Assertions.assertEquals(levelElement.get(j), levelElementRes.get(j));
            }
        }

    }

}