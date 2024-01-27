package com.maximilian.interview.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberOfIslandsTest {

    @Test
    void numIslands() {

        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int expected = 3;
        Assertions.assertEquals(expected, NumberOfIslands.numIslands(grid));

    }

}