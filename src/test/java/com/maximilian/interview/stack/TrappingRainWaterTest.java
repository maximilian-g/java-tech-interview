package com.maximilian.interview.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TrappingRainWaterTest {

    @Test
    void trap() {
        int[] test = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Assertions.assertEquals(6, TrappingRainWater.trap(test));

        test = new int[]{4, 2, 0, 3, 2, 5};
        Assertions.assertEquals(9, TrappingRainWater.trap(test));
    }

}