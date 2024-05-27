package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SpecialArrayTest {

    @Test
    void specialArray() {

        int[] input = {3, 5};
        int expected = 2;
        Assertions.assertEquals(expected, SpecialArray.specialArray(input));

        input = new int[]{0, 0};
        expected = -1;
        Assertions.assertEquals(expected, SpecialArray.specialArray(input));

        input = new int[]{0, 4, 3, 0, 4};
        expected = 3;
        Assertions.assertEquals(expected, SpecialArray.specialArray(input));

    }

}