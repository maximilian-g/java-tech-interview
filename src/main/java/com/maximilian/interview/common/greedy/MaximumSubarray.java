package com.maximilian.interview.common.greedy;

/**
 * Given an integer array nums, find the
 * subarray
 * with the largest sum, and return its sum.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 */
public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int maxSubArraySum = 0;
        int result = Integer.MIN_VALUE;
        for (int number : nums) {
            maxSubArraySum += number;
            maxSubArraySum = Math.max(number, maxSubArraySum);
            result = Math.max(result, maxSubArraySum);
        }
        return result;
    }

}
