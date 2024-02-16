package com.maximilian.interview.common.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumSubarrayTest {

    @Test
    void maxSubArray() {
        int[] input = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int expected = 6;
        Assertions.assertEquals(expected, MaximumSubarray.maxSubArray(input));

        input = new int[]{5, 4, -1, 7, 8};
        expected = 23;
        Assertions.assertEquals(expected, MaximumSubarray.maxSubArray(input));
    }

}