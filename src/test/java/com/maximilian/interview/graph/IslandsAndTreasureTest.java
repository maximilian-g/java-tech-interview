package com.maximilian.interview.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IslandsAndTreasureTest {

    @Test
    void islandsAndTreasure() {

        int[][] grid = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        };
        int[][] gridExpected = {
                {3, -1, 0, 1},
                {2, 2, 1, -1},
                {1, -1, 2, -1},
                {0, -1, 3, 4}
        };

        IslandsAndTreasure.islandsAndTreasure(grid);

        for (int i = 0; i < gridExpected.length; i++) {
            Assertions.assertArrayEquals(gridExpected[i], grid[i]);
        }

    }

}