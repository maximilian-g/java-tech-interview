package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WashMachinesTest {

    @Test
    void calculateTime() {

        Assertions.assertEquals(0, WashMachines.calculateTime(0, new int[]{}));
        Assertions.assertEquals(31, WashMachines.calculateTime(1, new int[]{3, 1, 9, 15, 3}));
        Assertions.assertEquals(18, WashMachines.calculateTime(2, new int[]{3, 1, 9, 15, 3}));
        Assertions.assertEquals(16, WashMachines.calculateTime(3, new int[]{3, 1, 9, 15, 3}));
        Assertions.assertEquals(15, WashMachines.calculateTime(4, new int[]{3, 1, 9, 15, 3}));
        Assertions.assertEquals(15, WashMachines.calculateTime(10, new int[]{3, 1, 9, 15, 3}));

    }

}