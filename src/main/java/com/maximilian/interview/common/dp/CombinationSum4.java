package com.maximilian.interview.common.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/combination-sum-iv/">Link to a task</a>
 * <p>
 * Given an array of distinct integers nums and a target integer target,
 * return the number of possible combinations that add up to target.
 * <p>
 * The test cases are generated so that the answer can fit in a 32-bit integer.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * All the elements of nums are unique.
 * 1 <= target <= 1000
 */
public class CombinationSum4 {

    public static int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        return backtrack(nums, target, new HashMap<>());
    }

    private static int backtrack(int[] nums, int target, Map<Integer, Integer> combinationsByTarget) {
        if (target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        if (combinationsByTarget.containsKey(target)) {
            return combinationsByTarget.get(target);
        }
        int result = 0;
        for (int num : nums) {
            result += backtrack(nums, target - num, combinationsByTarget);
        }
        combinationsByTarget.put(target, result);
        return result;
    }

}
