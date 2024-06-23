package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestContinuousSubarrayTest {

    @Test
    void longestSubarray() {

        int[] input = {2, 2, 2, 4, 4, 2, 5, 5, 5, 5, 5, 2};
        int limit = 2;
        int expected = 6;
        Assertions.assertEquals(expected, LongestContinuousSubarray.longestSubarray(input, limit));

        input = new int[]{1, 5, 6, 7, 8, 10, 6, 5, 6};
        limit = 4;
        expected = 5;
        Assertions.assertEquals(expected, LongestContinuousSubarray.longestSubarray(input, limit));

        input = new int[]{8, 2, 4, 7};
        expected = 2;
        Assertions.assertEquals(expected, LongestContinuousSubarray.longestSubarray(input, limit));

        input = new int[]{10, 1, 2, 4, 7, 2};
        limit = 5;
        expected = 4;
        Assertions.assertEquals(expected, LongestContinuousSubarray.longestSubarray(input, limit));

        input = new int[]{4, 2, 2, 2, 4, 4, 2, 2};
        limit = 0;
        expected = 3;
        Assertions.assertEquals(expected, LongestContinuousSubarray.longestSubarray(input, limit));

    }

}