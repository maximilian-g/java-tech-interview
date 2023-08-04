package com.maximilian.interview.common.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestPalindromicSubstringTest {

    @Test
    void longestPalindrome() {

        Assertions.assertEquals("bb", LongestPalindromicSubstring.longestPalindrome("abb"));
        Assertions.assertEquals("a", LongestPalindromicSubstring.longestPalindrome("a"));
        Assertions.assertEquals("bab", LongestPalindromicSubstring.longestPalindrome("babad"));
        Assertions.assertEquals("bb", LongestPalindromicSubstring.longestPalindrome("cbbd"));

    }

}