package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContainerWithMostWaterTest {

    @Test
    void maxArea() {

        Assertions.assertEquals(1, ContainerWithMostWater.maxArea(new int[]{1, 1}));
        Assertions.assertEquals(49, ContainerWithMostWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));

    }

}