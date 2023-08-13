package com.maximilian.interview.common.bits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReverseIntegerTest {

    @Test
    void reverse() {

        Assertions.assertEquals(321, ReverseInteger.reverse(123));
        Assertions.assertEquals(-321, ReverseInteger.reverse(-123));
        Assertions.assertEquals(21, ReverseInteger.reverse(120));

    }

}