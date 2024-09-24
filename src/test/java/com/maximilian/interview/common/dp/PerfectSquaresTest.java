package com.maximilian.interview.common.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PerfectSquaresTest {

    @Test
    void numSquares() {

        int n = 12;
        int expected = 3;
        Assertions.assertEquals(expected, PerfectSquares.numSquares(n));

        n = 13;
        expected = 2;
        Assertions.assertEquals(expected, PerfectSquares.numSquares(n));

        n = 48;
        expected = 3;
        Assertions.assertEquals(expected, PerfectSquares.numSquares(n));

    }

}