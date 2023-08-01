package com.maximilian.interview.common.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClimbingStairsTest {

    @Test
    void climbStairs() {

        Assertions.assertEquals(3, ClimbingStairs.climbStairs(3));
        Assertions.assertEquals(2, ClimbingStairs.climbStairs(2));
        Assertions.assertEquals(8, ClimbingStairs.climbStairs(5));
    }

    @Test
    void climbStairsBruteForce() {

        Assertions.assertEquals(3, ClimbingStairs.climbStairsBruteForce(3));
        Assertions.assertEquals(2, ClimbingStairs.climbStairsBruteForce(2));
        Assertions.assertEquals(8, ClimbingStairs.climbStairsBruteForce(5));

    }

    @Test
    void climbStairsBruteForceWithCache() {

        Assertions.assertEquals(3, ClimbingStairs.climbStairsBruteForceWithCache(3));
        Assertions.assertEquals(2, ClimbingStairs.climbStairsBruteForceWithCache(2));
        Assertions.assertEquals(8, ClimbingStairs.climbStairsBruteForceWithCache(5));

    }

}