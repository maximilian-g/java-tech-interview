package com.maximilian.interview.common.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HouseRobberTest {

    @Test
    void rob() {

        Assertions.assertEquals(4, HouseRobber.rob(new int[]{1, 2, 3, 1}));
        Assertions.assertEquals(12, HouseRobber.rob(new int[]{2, 7, 9, 3, 1}));

    }

    @Test
    void robRecursively() {

        Assertions.assertEquals(4, HouseRobber.robRecursively(new int[]{1, 2, 3, 1}));
        Assertions.assertEquals(12, HouseRobber.robRecursively(new int[]{2, 7, 9, 3, 1}));

    }

}