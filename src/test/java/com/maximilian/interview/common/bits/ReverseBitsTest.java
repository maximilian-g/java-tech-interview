package com.maximilian.interview.common.bits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReverseBitsTest {

    @Test
    void reverseBits() {

        Assertions.assertEquals(964176192,
                ReverseBits.reverseBits(Integer.parseInt("00000010100101000001111010011100", 2)));

    }

}