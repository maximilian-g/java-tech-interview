package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DailyTemperaturesTest {

    @Test
    void dailyTemperatures() {

        Assertions.assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, DailyTemperatures.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        Assertions.assertArrayEquals(new int[]{1, 1, 1, 0}, DailyTemperatures.dailyTemperatures(new int[]{30, 40, 50, 60}));
        Assertions.assertArrayEquals(new int[]{1, 1, 0}, DailyTemperatures.dailyTemperatures(new int[]{30, 60, 90}));

    }

}