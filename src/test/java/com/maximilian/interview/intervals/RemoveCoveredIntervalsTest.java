package com.maximilian.interview.intervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RemoveCoveredIntervalsTest {

    @Test
    void removeCoveredIntervals() {

        int[][] intervals = new int[][]{
                {1, 4},
                {3, 6},
                {2, 8}
        };
        int expectedToRemain = 2;
        int result = RemoveCoveredIntervals.removeCoveredIntervals(intervals);
        Assertions.assertEquals(expectedToRemain, result);

        intervals = new int[][]{
                {1, 4},
                {0, 5},
                {10, 15},
                {10, 16},
                {20, 26},
        };
        expectedToRemain = 3;
        result = RemoveCoveredIntervals.removeCoveredIntervals(intervals);
        Assertions.assertEquals(expectedToRemain, result);

        intervals = new int[][]{
                {1, 4},
        };
        expectedToRemain = 1;
        result = RemoveCoveredIntervals.removeCoveredIntervals(intervals);
        Assertions.assertEquals(expectedToRemain, result);
    }

}