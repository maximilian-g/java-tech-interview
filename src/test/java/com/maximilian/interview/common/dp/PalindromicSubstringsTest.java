package com.maximilian.interview.common.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PalindromicSubstringsTest {

    @Test
    void countSubstrings() {

        Assertions.assertEquals(3, PalindromicSubstrings.countSubstrings("abc"));
        Assertions.assertEquals(6, PalindromicSubstrings.countSubstrings("aaa"));

    }

}