package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoSumInSortedArrayTest {

    @Test
    void twoSum() {

        Assertions.assertArrayEquals(new int[]{1, 2}, TwoSumInSortedArray.twoSum(new int[]{2, 7, 11, 15}, 9));
        Assertions.assertArrayEquals(new int[]{1, 3}, TwoSumInSortedArray.twoSum(new int[]{2, 3, 4}, 6));
        Assertions.assertArrayEquals(new int[]{1, 2}, TwoSumInSortedArray.twoSum(new int[]{-1, 0}, -1));

    }

}