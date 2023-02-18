package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class BinarySearchTreeTest {

    @Test
    void insertAndContains() {
        BinarySearchTree<Integer> test = new BinarySearchTree<>();
        Assertions.assertFalse(test.contains(1));
        test.insert(1);
        Assertions.assertTrue(test.contains(1));
        test.insert(5);
        Assertions.assertTrue(test.contains(5));
        Assertions.assertDoesNotThrow(test::print);
    }

    @Test
    void bfsTest() {
        BinarySearchTree<Integer> test = new BinarySearchTree<>();
        test.insert(9);
        test.insert(6);
        test.insert(12);
        test.insert(1);
        test.insert(4);
        test.insert(34);
        test.insert(45);
        test.bfsTraversal();

        System.out.println();
        System.out.println();

        // dfs traversal
        test.print();
    }

    @Test
    void invertTest() {
        BinarySearchTree<Integer> test = new BinarySearchTree<>();
        test.insert(4);
        test.insert(2);
        test.insert(7);
        test.insert(1);
        test.insert(3);
        test.insert(6);
        test.insert(9);
        test.invert();
        Assertions.assertIterableEquals(List.of(4, 7, 9, 6, 2, 3, 1), test.getValuesAsList());
    }

}