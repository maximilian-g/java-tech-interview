package com.maximilian.interview.common.dp;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have
 * security systems connected, and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
public class HouseRobber {

    // dp bottom down solution
    public static int rob(int[] nums) {
        int max = nums[0];
        int s = 0;

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int tmp = max;
            max = Math.max(n + s, max);
            s = tmp;
        }

        return max;
    }

    public static int robRecursively(int[] nums) {
        return Math.max(robRecursively(nums, 0),
                robRecursively(nums, 1));
    }

    public static int robRecursively(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        // house that has index = index + 1 will trigger alarm
        return nums[index] + robRecursively(nums, index + 2);
    }

}
