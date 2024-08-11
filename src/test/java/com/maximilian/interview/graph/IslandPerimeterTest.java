package com.maximilian.interview.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IslandPerimeterTest {

    @Test
    void islandPerimeter() {

        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        int expected = 16;
        Assertions.assertEquals(expected, IslandPerimeter.islandPerimeter(grid));

        grid = new int[][]{
                {1}
        };
        expected = 4;
        Assertions.assertEquals(expected, IslandPerimeter.islandPerimeter(grid));

        grid = new int[][]{
                {1, 0}
        };
        Assertions.assertEquals(expected, IslandPerimeter.islandPerimeter(grid));

        grid = new int[][]{
                {0}
        };
        expected = 0;
        Assertions.assertEquals(expected, IslandPerimeter.islandPerimeter(grid));
    }

}