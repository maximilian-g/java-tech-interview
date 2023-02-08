package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GreatestCommonDivisorTest {

    @Test
    void getGcdRecursive() {
        Assertions.assertEquals(70, GreatestCommonDivisor.getGcdRecursive(140, 70));
        Assertions.assertEquals(70, GreatestCommonDivisor.getGcdRecursive(70, 140));
        Assertions.assertEquals(3, GreatestCommonDivisor.getGcdRecursive(30, 21));
        Assertions.assertEquals(1, GreatestCommonDivisor.getGcdRecursive(31, 17));
        Assertions.assertEquals(16, GreatestCommonDivisor.getGcdRecursive(64, 48));
    }

    @Test
    void getGcdIterative() {
        Assertions.assertEquals(70, GreatestCommonDivisor.getGcdIterative(140, 70));
        Assertions.assertEquals(70, GreatestCommonDivisor.getGcdIterative(70, 140));
        Assertions.assertEquals(3, GreatestCommonDivisor.getGcdIterative(30, 21));
        Assertions.assertEquals(1, GreatestCommonDivisor.getGcdIterative(31, 17));
        Assertions.assertEquals(16, GreatestCommonDivisor.getGcdIterative(64, 48));
    }

}