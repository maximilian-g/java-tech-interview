package com.maximilian.interview.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarFleetTest {

    @Test
    void carFleet() {
        int target = 12;
        int[] pos = new int[]{10, 8, 0, 5, 3};
        int[] speed = new int[]{2, 4, 1, 1, 3};
        Assertions.assertEquals(3, CarFleet.carFleet(target, pos, speed));
    }

}