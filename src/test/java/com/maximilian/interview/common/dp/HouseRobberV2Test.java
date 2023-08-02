package com.maximilian.interview.common.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HouseRobberV2Test {

    @Test
    void rob() {

        Assertions.assertEquals(1, HouseRobberV2.rob(new int[]{1}));
        Assertions.assertEquals(3, HouseRobberV2.rob(new int[]{2, 3, 2}));
        Assertions.assertEquals(4, HouseRobberV2.rob(new int[]{1, 2, 3, 1}));
        Assertions.assertEquals(3, HouseRobberV2.rob(new int[]{1, 2, 3}));

    }

    @Test
    void robRecursively() {

        Assertions.assertEquals(1, HouseRobberV2.robRecursively(new int[]{1}));
        Assertions.assertEquals(3, HouseRobberV2.robRecursively(new int[]{2, 3, 2}));
        Assertions.assertEquals(4, HouseRobberV2.robRecursively(new int[]{1, 2, 3, 1}));
        Assertions.assertEquals(3, HouseRobberV2.robRecursively(new int[]{1, 2, 3}));

    }

}