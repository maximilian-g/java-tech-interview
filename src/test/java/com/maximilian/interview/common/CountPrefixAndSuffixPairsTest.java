package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountPrefixAndSuffixPairsTest {

    @Test
    void countPrefixSuffixPairs() {
        String[] words = {"a", "aba", "ababa", "aa"};
        int expected = 4;
        Assertions.assertEquals(expected, CountPrefixAndSuffixPairs.countPrefixSuffixPairs(words));
    }

}