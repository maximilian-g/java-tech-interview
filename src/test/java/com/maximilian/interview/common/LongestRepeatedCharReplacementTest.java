package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestRepeatedCharReplacementTest {

    @Test
    void characterReplacement() {
        String test = "ABAB";
        int k = 2;

        Assertions.assertEquals(4, LongestRepeatedCharReplacement.characterReplacement(test, k));

        test = "AABABBA";
        k = 1;
        Assertions.assertEquals(4, LongestRepeatedCharReplacement.characterReplacement(test, k));

    }

}