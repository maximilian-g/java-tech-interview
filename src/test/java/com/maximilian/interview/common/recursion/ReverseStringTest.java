package com.maximilian.interview.common.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReverseStringTest {

    @Test
    void reverse() {
        String test = "Hell";
        Assertions.assertEquals("lleH", ReverseString.reverse(test));
        test = "test";
        Assertions.assertEquals("tset", ReverseString.reverse(test));
        test = "tel";
        Assertions.assertEquals("let", ReverseString.reverse(test));
        test = "az";
        Assertions.assertEquals("za", ReverseString.reverse(test));
        test = "a";
        Assertions.assertEquals("a", ReverseString.reverse(test));
        test = "";
        Assertions.assertEquals("", ReverseString.reverse(test));
    }

}