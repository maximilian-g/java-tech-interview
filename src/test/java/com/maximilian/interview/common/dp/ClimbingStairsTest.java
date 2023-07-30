package com.maximilian.interview.common.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClimbingStairsTest {

    @Test
    void climbStairs() {

        Assertions.assertEquals(3, ClimbingStairs.climbStairs(3));
        Assertions.assertEquals(2, ClimbingStairs.climbStairs(2));

    }

}