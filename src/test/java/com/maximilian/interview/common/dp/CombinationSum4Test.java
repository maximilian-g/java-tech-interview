package com.maximilian.interview.common.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CombinationSum4Test {

    @Test
    void combinationSum4() {

        int[] nums = {1, 2, 3};
        int target = 4;
        int expected = 7;
        Assertions.assertEquals(expected, CombinationSum4.combinationSum4(nums, target));

        nums = new int[]{9};
        target = 3;
        expected = 0;
        Assertions.assertEquals(expected, CombinationSum4.combinationSum4(nums, target));

        nums = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        target = 10;
        expected = 9;
        Assertions.assertEquals(expected, CombinationSum4.combinationSum4(nums, target));

    }

}