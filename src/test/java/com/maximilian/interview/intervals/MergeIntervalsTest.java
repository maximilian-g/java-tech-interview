package com.maximilian.interview.intervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeIntervalsTest {

    @Test
    void merge() {

        int[][] input = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        int[][] expected = new int[][]{
                {1, 6},
                {8, 10},
                {15, 18}
        };

        int[][] result = MergeIntervals.merge(input);

        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertArrayEquals(expected[i], result[i]);
        }


        input = new int[][]{
                {1, 4},
                {4, 5}
        };
        expected = new int[][]{
                {1, 5}
        };

        result = MergeIntervals.merge(input);

        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertArrayEquals(expected[i], result[i]);
        }
    }

}