package com.maximilian.interview.common.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntegerBreakTest {

    @Test
    void integerBreak() {

        Assertions.assertEquals(1, IntegerBreak.integerBreak(2));
        Assertions.assertEquals(6, IntegerBreak.integerBreak(5));
        Assertions.assertEquals(36, IntegerBreak.integerBreak(10));

    }

}