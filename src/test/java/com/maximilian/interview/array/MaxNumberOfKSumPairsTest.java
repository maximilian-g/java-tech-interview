package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxNumberOfKSumPairsTest {

    @Test
    void maxOperations() {

        int[] nums = {1, 2, 3, 4};
        int k = 5;
        int expected = 2;
        Assertions.assertEquals(expected, MaxNumberOfKSumPairs.maxOperations(nums, k));
        Assertions.assertEquals(expected, MaxNumberOfKSumPairs.maxOperations2Pointers(nums, k));

        nums = new int[]{3, 1, 3, 4, 3};
        k = 6;
        expected = 1;
        Assertions.assertEquals(expected, MaxNumberOfKSumPairs.maxOperations(nums, k));
        Assertions.assertEquals(expected, MaxNumberOfKSumPairs.maxOperations2Pointers(nums, k));

    }

}