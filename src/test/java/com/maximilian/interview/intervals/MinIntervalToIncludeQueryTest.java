package com.maximilian.interview.intervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinIntervalToIncludeQueryTest {

    @Test
    void minInterval() {
        int[] queries = new int[]{2, 3, 4, 5};
        int[] expected = new int[]{3, 3, 1, 4};
        int[][] intervals = new int[][]{
                {1, 4},
                {2, 4},
                {3, 6},
                {4, 4}
        };
        int[] result = MinIntervalToIncludeQuery.minIntervalAnotherAnother(intervals, queries);
        Assertions.assertArrayEquals(expected, result);

        queries = new int[]{2, 19, 5, 22};
        expected = new int[]{2, -1, 4, 6};
        intervals = new int[][]{
                {2, 3},
                {2, 5},
                {1, 8},
                {20, 25}
        };
        result = MinIntervalToIncludeQuery.minInterval(intervals, queries);
        Assertions.assertArrayEquals(expected, result);
    }

}