package com.maximilian.interview.common.bits;

/**
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 */
public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        // calculating sum of arithmetical increasing sequence 1+2+...+n = n*(n+1)/2
        int total = n * (n + 1) / 2;
        for (int num : nums) {
            total -= num;
        }
        return total;
    }

}
