package com.maximilian.interview.common.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if you can partition
 * the array into two subsets such that the sum of the elements
 * in both subsets is equal or false otherwise.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        set.add(0);
        int target = sum / 2;

        for (int i = nums.length - 1; i >= 0; i--) {
            Set<Integer> newSet = new HashSet<>(set);
            for (int val : set) {
                newSet.add(val + nums[i]);
            }
            set = newSet;
        }
        return set.contains(target);
    }

}
