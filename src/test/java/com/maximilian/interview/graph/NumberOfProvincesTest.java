package com.maximilian.interview.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberOfProvincesTest {

    @Test
    void findCircleNum() {

        int[][] adjMatrix = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int expected = 2;
        Assertions.assertEquals(expected, NumberOfProvinces.findCircleNum(adjMatrix));

        adjMatrix = new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        expected = 3;
        Assertions.assertEquals(expected, NumberOfProvinces.findCircleNum(adjMatrix));

    }

}