package com.maximilian.interview.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/max-number-of-k-sum-pairs/description">
 * Link to a task</a>
 * <p>
 * You are given an integer array nums and an integer k.
 * <p>
 * In one operation, you can pick two numbers from the array whose sum
 * equals k and remove them from the array.
 * <p>
 * Return the maximum number of operations you can perform on the array.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= k <= 10^9
 */
public class MaxNumberOfKSumPairs {

    public static int maxOperations(int[] nums, int k) {
        int maxOperations = 0;
        Map<Integer, Integer> quantityByNumber = new HashMap<>();
        for (int num : nums) {
            quantityByNumber.put(num, quantityByNumber.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            int currentNumQuantity = quantityByNumber.getOrDefault(num, 0);
            if (currentNumQuantity == 0) {
                continue;
            }

            int anotherDesiredNum = k - num;
            int anotherNumQuantity = quantityByNumber.getOrDefault(anotherDesiredNum, 0);
            if (num == anotherDesiredNum && currentNumQuantity - 2 < 0) {
                continue;
            }
            if (anotherNumQuantity != 0) {
                maxOperations++;
                quantityByNumber.put(anotherDesiredNum, quantityByNumber.get(anotherDesiredNum) - 1);
                quantityByNumber.put(num, quantityByNumber.get(num) - 1);
            }
        }
        return maxOperations;
    }

    public static int maxOperations2Pointers(int[] nums, int k) {
        Arrays.sort(nums);
        int maxOperations = 0;
        for (int i = 0, j = nums.length - 1; i < j; ) {
            if (nums[i] + nums[j] == k) {
                maxOperations++;
                j--;
                i++;
            } else if (nums[i] + nums[j] > k) {
                j--;
            } else {
                i++;
            }
        }
        return maxOperations;
    }

}
