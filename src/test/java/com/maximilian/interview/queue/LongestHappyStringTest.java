package com.maximilian.interview.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LongestHappyStringTest {

    @Test
    void longestDiverseString() {

        List<String> expectedAnswers = List.of("ccaccbcc", "ccbccacc");

        String result = LongestHappyString.longestDiverseString(1, 1, 7);
        Assertions.assertTrue(expectedAnswers.contains(result));

        expectedAnswers = List.of("aabaa");
        result = LongestHappyString.longestDiverseString(7, 1, 0);
        Assertions.assertTrue(expectedAnswers.contains(result));

    }

}