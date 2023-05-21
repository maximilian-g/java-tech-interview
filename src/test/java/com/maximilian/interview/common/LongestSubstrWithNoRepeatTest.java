package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestSubstrWithNoRepeatTest {

    @Test
    void lengthOfLongestSubstring() {

        String test = "abcabcbb";
        Assertions.assertEquals(3, LongestSubstrWithNoRepeat.lengthOfLongestSubstring(test));

        test = "bbbbb";
        Assertions.assertEquals(1, LongestSubstrWithNoRepeat.lengthOfLongestSubstring(test));

        test = "pwwkew";
        Assertions.assertEquals(3, LongestSubstrWithNoRepeat.lengthOfLongestSubstring(test));

    }

}