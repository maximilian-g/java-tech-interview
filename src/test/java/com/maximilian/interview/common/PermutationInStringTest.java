package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PermutationInStringTest {

    @Test
    void checkInclusion() {
        String s1 = "ab";
        String s2 = "eidbaooo";

        Assertions.assertTrue(PermutationInString.checkInclusion(s1, s2));

        s2 = "eidboaoo";
        Assertions.assertFalse(PermutationInString.checkInclusion(s1, s2));

        s1 = "abc";
        s2 = "cccccbabbbaaaa";
        Assertions.assertTrue(PermutationInString.checkInclusion(s1, s2));

        s1 = "adc";
        s2 = "dcda";
        Assertions.assertTrue(PermutationInString.checkInclusion(s1, s2));

    }

}