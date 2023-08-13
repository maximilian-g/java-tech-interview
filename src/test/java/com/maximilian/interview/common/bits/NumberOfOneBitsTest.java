package com.maximilian.interview.common.bits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberOfOneBitsTest {

    @Test
    void hammingWeight() {

        Assertions.assertEquals(3, NumberOfOneBits.hammingWeight(11));

    }

}