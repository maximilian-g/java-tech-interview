package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PostOrderTraversalTest {

    @Test
    void postorderTraversal() {

        TreeNode<Integer> node = new TreeNode<>(1, null,
                new TreeNode<>(3, null, new TreeNode<>(5)));

        List<Integer> expected = List.of(5, 3, 1);

        List<Integer> actual = PostOrderTraversal.postorderTraversal(node);

        Assertions.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), actual.get(i));
        }

    }

}