package com.maximilian.interview.array;

/**
 * You are given an array nums of non-negative integers.
 * nums is considered special if there exists a number x
 * such that there are exactly x numbers in nums that are greater than or equal to x.
 * <p>
 * Notice that x does not have to be an element in nums.
 * <p>
 * Return x if the array is special, otherwise, return -1.
 * It can be proven that if nums is special, the value for x is unique.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 */
public class SpecialArray {

    public static int specialArray(int[] nums) {
        int x = nums.length;
        int[] counts = new int[x + 1];

        for (int elem : nums) {
            if (elem >= x) {
                counts[x]++;
            } else {
                counts[elem]++;
            }
        }

        int res = 0;
        for (int i = counts.length - 1; i > 0; i--) {
            res += counts[i];
            if (res == i) {
                return i;
            }
        }

        return -1;
    }

}
