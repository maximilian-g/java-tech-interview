package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LeafSimilarTreesTest {

    @Test
    void leafSimilar() {

        TreeNode<Integer> root1 = new TreeNode<>(5,
                new TreeNode<>(2), new TreeNode<>(7));

        TreeNode<Integer> root2 = new TreeNode<>(5,
                new TreeNode<>(2), new TreeNode<>(7, null, new TreeNode<>(7)));

        Assertions.assertTrue(LeafSimilarTrees.leafSimilar(root1, root2));

    }

}