package com.maximilian.interview.algo.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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