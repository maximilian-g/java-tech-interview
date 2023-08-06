package com.maximilian.interview.common.dp;

import java.util.Arrays;

/**
 * Given an integer array nums, return the length of the longest strictly increasing
 * subsequence
 * <p>
 * Example
 * <p>
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 */
public class LongestIncreasingSubsequence {

    public static int lengthOfLISDpBottomUp(int[] nums) {
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);
        int maxTemp = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    lis[i] = Math.max(lis[i], Math.max(1, lis[j] + 1));
                }
            }
            maxTemp = Math.max(lis[i], maxTemp);
        }
        return maxTemp;
    }

}
