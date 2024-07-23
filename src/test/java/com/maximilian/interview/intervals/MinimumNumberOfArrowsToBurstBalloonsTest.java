package com.maximilian.interview.intervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumNumberOfArrowsToBurstBalloonsTest {

    @Test
    void findMinArrowShots() {

        int[][] arr = {
                {10, 16},
                {2, 8},
                {1, 6},
                {7, 12}
        };
        int expected = 2;
        Assertions.assertEquals(expected, MinimumNumberOfArrowsToBurstBalloons.findMinArrowShots(arr));

        arr = new int[][]{
                {3, 9},
                {7, 12},
                {3, 8},
                {6, 8},
                {9, 10},
                {2, 9},
                {0, 9},
                {3, 9},
                {0, 6},
                {2, 8}
        };
        Assertions.assertEquals(expected, MinimumNumberOfArrowsToBurstBalloons.findMinArrowShots(arr));

        arr = new int[][]{{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}};
        Assertions.assertEquals(expected, MinimumNumberOfArrowsToBurstBalloons.findMinArrowShots(arr));

    }

}