package com.maximilian.interview.common.dp;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have a security system connected,
 * and it will automatically contact the police if two adjacent
 * houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 */
public class HouseRobberV2 {

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(helper(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                helper(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public static int helper(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        for (int num : nums) {
            int max = Math.max(rob1 + num, rob2);
            rob1 = rob2;
            rob2 = max;
        }
        return rob2;
    }

    public static int robRecursively(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, robRecursively(nums, i, i == 0));
        }
        return max;
    }

    public static int robRecursively(int[] nums, int index, boolean startedWithFirst) {
        // check for the last house because houses are in circle
        if (index >= nums.length || (startedWithFirst && index == nums.length - 1 && nums.length > 1)) {
            return 0;
        }
        // house that has index = index + 1 will trigger alarm
        return nums[index] + robRecursively(nums, index + 2, startedWithFirst);
    }

}
