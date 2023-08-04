package com.maximilian.interview.common.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DecodeWaysTest {

    @Test
    void numDecodings() {

        Assertions.assertEquals(2, DecodeWays.numDecodingsRecursive("12"));
        Assertions.assertEquals(3, DecodeWays.numDecodingsRecursive("226"));

    }

    @Test
    void numDecodingsBottomUp() {

        Assertions.assertEquals(2, DecodeWays.numDecodingsDpBottomUp("12"));
        Assertions.assertEquals(3, DecodeWays.numDecodingsDpBottomUp("226"));

    }

}