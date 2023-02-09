package com.maximilian.interview.common.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @Test
    void binarySearch() {

        int[] test = new int[]{1, 4, 7, 8, 11, 15};

        Assertions.assertEquals(0, BinarySearch.binarySearch(test, 1));
        Assertions.assertEquals(1, BinarySearch.binarySearch(test, 4));
        Assertions.assertEquals(2, BinarySearch.binarySearch(test, 7));
        Assertions.assertEquals(3, BinarySearch.binarySearch(test, 8));
        Assertions.assertEquals(4, BinarySearch.binarySearch(test, 11));
        Assertions.assertEquals(5, BinarySearch.binarySearch(test, 15));

        Assertions.assertEquals(-1, BinarySearch.binarySearch(test, 666));
        Assertions.assertEquals(-1, BinarySearch.binarySearch(test, -124));
        Assertions.assertEquals(-1, BinarySearch.binarySearch(test, 0));
        Assertions.assertEquals(-1, BinarySearch.binarySearch(test, 2));
        Assertions.assertEquals(-1, BinarySearch.binarySearch(test, 10));

    }

}