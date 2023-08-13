package com.maximilian.interview.common.bits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SumOfTwoIntegersTest {

    @Test
    void getSum() {

        Assertions.assertEquals(2, SumOfTwoIntegers.getSum(1, 1));
        Assertions.assertEquals(10, SumOfTwoIntegers.getSum(5, 5));
        Assertions.assertEquals(1, SumOfTwoIntegers.getSum(1, 0));
        Assertions.assertEquals(0, SumOfTwoIntegers.getSum(0, 0));

    }

}