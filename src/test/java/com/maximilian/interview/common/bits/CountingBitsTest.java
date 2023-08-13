package com.maximilian.interview.common.bits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountingBitsTest {

    @Test
    void countBits() {

        Assertions.assertArrayEquals(new int[]{0, 1, 1},
                CountingBits.countBits(2));
        Assertions.assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2},
                CountingBits.countBits(5));

    }

}