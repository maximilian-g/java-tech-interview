package com.maximilian.interview.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinReorderTest {

    @Test
    void minReorder() {

        int[][] connections = {
                {0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}
        };
        int n = 6;
        int expected = 3;
        Assertions.assertEquals(expected, MinReorder.minReorder(n, connections));

        connections = new int[][]{
                {1, 0}, {1, 2}, {3, 2}, {3, 4}
        };
        n = 5;
        expected = 2;
        Assertions.assertEquals(expected, MinReorder.minReorder(n, connections));

        connections = new int[][]{
                {1, 0}, {2, 0}
        };
        n = 3;
        expected = 0;
        Assertions.assertEquals(expected, MinReorder.minReorder(n, connections));

        connections = new int[][]{
                {4, 3}, {2, 3}, {1, 2}, {1, 0}
        };
        n = 5;
        expected = 2;
        Assertions.assertEquals(expected, MinReorder.minReorder(n, connections));

        connections = new int[][]{
                {1, 2}, {2, 0}
        };
        n = 3;
        expected = 0;
        Assertions.assertEquals(expected, MinReorder.minReorder(n, connections));

    }

}