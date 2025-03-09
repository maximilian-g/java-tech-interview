package com.maximilian.interview.common.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchInsertionPointTest {

    @Test
    void searchInsert() {

        int[] input = {1, 3, 5, 6};
        int target = 5;
        Assertions.assertEquals(2, BinarySearchInsertionPoint.searchInsert(input, target));

        target = 2;
        Assertions.assertEquals(1, BinarySearchInsertionPoint.searchInsert(input, target));

        target = 7;
        Assertions.assertEquals(4, BinarySearchInsertionPoint.searchInsert(input, target));

        target = 0;
        Assertions.assertEquals(0, BinarySearchInsertionPoint.searchInsert(input, target));

        target = 1;
        Assertions.assertEquals(0, BinarySearchInsertionPoint.searchInsert(input, target));

    }

}