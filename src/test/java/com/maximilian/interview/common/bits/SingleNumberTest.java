package com.maximilian.interview.common.bits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SingleNumberTest {

    @Test
    void singleNumber() {

        Assertions.assertEquals(1, SingleNumber.singleNumber(new int[]{2, 2, 1}));
        Assertions.assertEquals(4, SingleNumber.singleNumber(new int[]{4, 1, 2, 1, 2}));
        Assertions.assertEquals(1, SingleNumber.singleNumber(new int[]{1}));

    }

}