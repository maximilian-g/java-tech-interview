package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TreeSerializerTest {

    @Test
    void serialize() {
        TreeNode<Integer> root = new TreeNode<>(
                1,
                new TreeNode<>(2),
                new TreeNode<>(3, new TreeNode<>(4), new TreeNode<>(5))
        );

        TreeSerializer treeSerializer = new TreeSerializer();

        Assertions.assertEquals("1,2,N,N,3,4,N,N,5,N,N", treeSerializer.serialize(root));

    }

    @Test
    void deserialize() {

        TreeNode<Integer> root = new TreeNode<>(
                1,
                new TreeNode<>(2),
                new TreeNode<>(3, new TreeNode<>(4), new TreeNode<>(5))
        );

        TreeSerializer treeSerializer = new TreeSerializer();

        Assertions.assertTrue(SameTree.isSameTree(root,
                treeSerializer.deserialize("1,2,N,N,3,4,N,N,5,N,N")));

    }

}