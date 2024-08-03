package com.maximilian.interview.common.bits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumFlipsTest {

    @Test
    void minFlips() {

        int a = 2;
        int b = 6;
        int c = 5;
        int expected = 3;
        Assertions.assertEquals(expected, MinimumFlips.minFlips(a, b, c));

    }

}