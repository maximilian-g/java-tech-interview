package com.maximilian.interview.intervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

class NonOverlappingIntervalsTest {

    @Test
    void eraseOverlapIntervals() {
        LocalTime parse = LocalTime.parse("12:00");
        LocalTime parse1 = LocalTime.parse("13:00");
        System.out.println(parse);

        int[][] intervals = new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };
        int expectedIntervalsToRemove = 1;
        int result = NonOverlappingIntervals.eraseOverlapIntervals(intervals);

        Assertions.assertEquals(expectedIntervalsToRemove, result);

        intervals = new int[][]{
                {1, 2},
                {1, 2},
                {1, 2}
        };
        expectedIntervalsToRemove = 2;
        result = NonOverlappingIntervals.eraseOverlapIntervals(intervals);

        Assertions.assertEquals(expectedIntervalsToRemove, result);

        intervals = new int[][]{
                {1, 2},
                {2, 3}
        };
        expectedIntervalsToRemove = 0;
        result = NonOverlappingIntervals.eraseOverlapIntervals(intervals);

        Assertions.assertEquals(expectedIntervalsToRemove, result);

    }

}