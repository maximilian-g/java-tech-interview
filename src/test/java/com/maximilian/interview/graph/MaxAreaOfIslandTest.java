package com.maximilian.interview.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxAreaOfIslandTest {

    @Test
    void maxAreaOfIsland() {

        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        int expected = 6;

        Assertions.assertEquals(expected, MaxAreaOfIsland.maxAreaOfIsland(grid));

        grid = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        expected = 0;

        Assertions.assertEquals(expected, MaxAreaOfIsland.maxAreaOfIsland(grid));

    }

}