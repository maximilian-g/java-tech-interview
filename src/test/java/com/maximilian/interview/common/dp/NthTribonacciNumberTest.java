package com.maximilian.interview.common.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NthTribonacciNumberTest {

    @Test
    void tribonacci() {

        int n = 25;
        int expected = 1389537;
        Assertions.assertEquals(expected, NthTribonacciNumber.tribonacci(n));
        Assertions.assertEquals(0, NthTribonacciNumber.tribonacci(0));

    }

}