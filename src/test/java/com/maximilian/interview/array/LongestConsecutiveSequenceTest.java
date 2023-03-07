package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestConsecutiveSequenceTest {

    @Test
    void longestConsecutive() {

        Assertions.assertEquals(0, LongestConsecutiveSequence.longestConsecutive(new int[]{}));
        Assertions.assertEquals(1, LongestConsecutiveSequence.longestConsecutive(new int[]{1, 3}));
        Assertions.assertEquals(2, LongestConsecutiveSequence.longestConsecutive(new int[]{1, 2}));
        Assertions.assertEquals(4, LongestConsecutiveSequence.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        Assertions.assertEquals(9, LongestConsecutiveSequence.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));

    }

}