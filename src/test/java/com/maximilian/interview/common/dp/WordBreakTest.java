package com.maximilian.interview.common.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class WordBreakTest {

    @Test
    void wordBreak() {

        Assertions.assertTrue(WordBreak.wordBreak(
                "leetcode",
                List.of("leet", "code")
        ));
        Assertions.assertTrue(WordBreak.wordBreak(
                "applepenapple",
                List.of("apple", "pen")
        ));
        Assertions.assertFalse(WordBreak.wordBreak(
                "catsandog",
                List.of("cats", "dog", "sand", "and", "cat")
        ));
        Assertions.assertTrue(WordBreak.wordBreak(
                "cars",
                List.of("car", "ca", "rs")
        ));
        Assertions.assertFalse(WordBreak.wordBreak(
                "cbca",
                List.of("bc", "ca")
        ));
        Assertions.assertTrue(WordBreak.wordBreak(
                "ccaccc",
                List.of("cc", "ac")
        ));
    }

}