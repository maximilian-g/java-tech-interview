package com.maximilian.interview.common.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestIncreasingSubsequenceTest {

    @Test
    void lengthOfLIS() {

        Assertions.assertEquals(1,
                LongestIncreasingSubsequence.lengthOfLISDpBottomUp(new int[]{7, 7, 7, 7, 7, 7, 7}));
        Assertions.assertEquals(4,
                LongestIncreasingSubsequence.lengthOfLISDpBottomUp(new int[]{0, 1, 0, 3, 2, 3}));
        Assertions.assertEquals(4,
                LongestIncreasingSubsequence.lengthOfLISDpBottomUp(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));

    }

}