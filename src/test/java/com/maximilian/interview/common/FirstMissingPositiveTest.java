package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FirstMissingPositiveTest {

    @Test
    void firstMissingPositive() {

        Assertions.assertEquals(3, FirstMissingPositive.firstMissingPositive(new int[]{0, 1, 2}));
        Assertions.assertEquals(2, FirstMissingPositive.firstMissingPositive(new int[]{3, 4, -1, 1}));
        Assertions.assertEquals(1, FirstMissingPositive.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));

        Assertions.assertEquals(3, FirstMissingPositive.firstMissingPositiveV2(new int[]{0, 1, 2}));
        Assertions.assertEquals(2, FirstMissingPositive.firstMissingPositiveV2(new int[]{3, 4, -1, 1}));
        Assertions.assertEquals(1, FirstMissingPositive.firstMissingPositiveV2(new int[]{7, 8, 9, 11, 12}));

        Assertions.assertEquals(3, FirstMissingPositive.firstMissingPositiveV3(new int[]{0, 1, 2}));
        Assertions.assertEquals(2, FirstMissingPositive.firstMissingPositiveV3(new int[]{3, 4, -1, 1}));
        Assertions.assertEquals(1, FirstMissingPositive.firstMissingPositiveV3(new int[]{7, 8, 9, 11, 12}));

    }

}