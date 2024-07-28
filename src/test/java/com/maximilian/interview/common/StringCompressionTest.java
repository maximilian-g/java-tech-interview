package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringCompressionTest {

    @Test
    void compress() {
        String input = "aaabbcccxvv";
        String expected = "a3b2c3xv2";
        Assertions.assertEquals(expected, StringCompression.compress(input.toCharArray()));
    }

}