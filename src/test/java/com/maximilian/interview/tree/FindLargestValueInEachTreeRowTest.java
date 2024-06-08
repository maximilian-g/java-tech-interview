package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class FindLargestValueInEachTreeRowTest {

    @Test
    void largestValues() {
        TreeNode<Integer> root = new TreeNode<>(
                1,
                new TreeNode<>(3, new TreeNode<>(5), new TreeNode<>(3)),
                new TreeNode<>(2, null, new TreeNode<>(9))
        );
        List<Integer> expected = List.of(1, 3, 9);
        List<Integer> result = FindLargestValueInEachTreeRow.largestValues(root);
        Assertions.assertIterableEquals(expected, result);

        root = new TreeNode<>(
                1,
                new TreeNode<>(2),
                new TreeNode<>(3)
        );
        expected = List.of(1, 3);
        result = FindLargestValueInEachTreeRow.largestValues(root);
        Assertions.assertIterableEquals(expected, result);
    }

}