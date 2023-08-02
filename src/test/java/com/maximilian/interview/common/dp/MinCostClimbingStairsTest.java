package com.maximilian.interview.common.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinCostClimbingStairsTest {

    @Test
    void minCostClimbingStairs() {

        Assertions.assertEquals(15,
                MinCostClimbingStairs.minCostClimbingStairsBottomUp(new int[]{10, 15, 20}));

        Assertions.assertEquals(6,
                MinCostClimbingStairs.minCostClimbingStairsBottomUp(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));

    }

    @Test
    void minCostClimbingStairsBottomDown() {

        Assertions.assertEquals(15,
                MinCostClimbingStairs.minCostClimbingStairsBottomDown(new int[]{10, 15, 20}));

        Assertions.assertEquals(6,
                MinCostClimbingStairs.minCostClimbingStairsBottomDown(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));

    }

    @Test
    void minCostClimbingStairsRecursive() {

        Assertions.assertEquals(15,
                MinCostClimbingStairs.minCostClimbingStairsRecursive(new int[]{10, 15, 20}));

        Assertions.assertEquals(6,
                MinCostClimbingStairs.minCostClimbingStairsRecursive(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));

    }

}