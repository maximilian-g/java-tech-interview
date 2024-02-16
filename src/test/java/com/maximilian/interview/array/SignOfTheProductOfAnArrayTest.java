package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SignOfTheProductOfAnArrayTest {

    @Test
    void arraySign() {
        int[] input = new int[]{-1, -2, -3, -4, 3, 2, 1};
        int expected = 1;
        Assertions.assertEquals(expected, SignOfTheProductOfAnArray.arraySign(input));

        input = new int[]{1, 5, 0, 2, -3};
        expected = 0;
        Assertions.assertEquals(expected, SignOfTheProductOfAnArray.arraySign(input));
    }

}