package com.maximilian.interview.common.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinEatingSpeedTest {

    @Test
    void minEatingSpeed() {
        int[] testPiles = new int[]{3, 6, 7, 11};
        int h = 8;

        Assertions.assertEquals(4, MinEatingSpeed.minEatingSpeed(testPiles, h));

        testPiles = new int[]{30, 11, 23, 4, 20};
        h = 5;

        Assertions.assertEquals(30, MinEatingSpeed.minEatingSpeed(testPiles, h));

        testPiles = new int[]{30, 11, 23, 4, 20};
        h = 6;

        Assertions.assertEquals(23, MinEatingSpeed.minEatingSpeed(testPiles, h));

    }

}