package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseDigitOrderTest {

    @Test
    void revertDigitOrder() {
        Assertions.assertEquals(321, ReverseDigitOrder.revertDigitOrder(12300));
        Assertions.assertEquals(321, ReverseDigitOrder.revertDigitOrder(1230));
        Assertions.assertEquals(321, ReverseDigitOrder.revertDigitOrder(123));
        Assertions.assertEquals(21, ReverseDigitOrder.revertDigitOrder(12));
        Assertions.assertEquals(101, ReverseDigitOrder.revertDigitOrder(101));
        Assertions.assertEquals(1101, ReverseDigitOrder.revertDigitOrder(1011));
        Assertions.assertEquals(1, ReverseDigitOrder.revertDigitOrder(1));
        Assertions.assertEquals(0, ReverseDigitOrder.revertDigitOrder(0));
        Assertions.assertEquals(-995, ReverseDigitOrder.revertDigitOrder(-599));
    }

    @Test
    void revertDigitOrderUsingChars() {

        Assertions.assertEquals(321, ReverseDigitOrder.revertDigitOrderUsingChars(12300));
        Assertions.assertEquals(321, ReverseDigitOrder.revertDigitOrderUsingChars(1230));
        Assertions.assertEquals(321, ReverseDigitOrder.revertDigitOrderUsingChars(123));
        Assertions.assertEquals(21, ReverseDigitOrder.revertDigitOrderUsingChars(12));
        Assertions.assertEquals(101, ReverseDigitOrder.revertDigitOrder(101));
        Assertions.assertEquals(1101, ReverseDigitOrder.revertDigitOrder(1011));
        Assertions.assertEquals(1, ReverseDigitOrder.revertDigitOrderUsingChars(1));
        Assertions.assertEquals(0, ReverseDigitOrder.revertDigitOrderUsingChars(0));
        Assertions.assertEquals(-995, ReverseDigitOrder.revertDigitOrderUsingChars(-599));

    }

}