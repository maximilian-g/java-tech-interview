package com.maximilian.interview.array;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 */
public class SortedSquares {

    // O(n * log n)
    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        System.arraycopy(nums, 0, res, 0, nums.length);
        for(int i = 0; i < res.length; i++) {
            res[i] *= res[i];
        }
        Arrays.sort(res);
        return res;
    }

}
