package com.maximilian.interview.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RottingOrangesTest {

    @Test
    void orangesRotting() {

        int[][] grid = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        int expected = 4;
        Assertions.assertEquals(expected, RottingOranges.orangesRotting(grid));

        grid = new int[][]{
                {2, 1, 1},
                {1, 0, 0},
                {0, 1, 1}
        };
        expected = -1;
        Assertions.assertEquals(expected, RottingOranges.orangesRotting(grid));


        grid = new int[][]{
                {2},
                {2},
                {1},
                {0},
                {1},
                {2},
                {2}
        };
        expected = 1;
        Assertions.assertEquals(expected, RottingOranges.orangesRotting(grid));

        grid = new int[][]{
                {2, 2},
                {1, 1},
                {0, 0},
                {2, 0}
        };
        Assertions.assertEquals(expected, RottingOranges.orangesRotting(grid));

    }

}