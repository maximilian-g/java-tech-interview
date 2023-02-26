package com.maximilian.interview.array;

import java.util.Arrays;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 *
 * 1 <= n <= 105
 *
 * nums.length == n + 1
 *
 * 1 <= nums[i] <= n
 *
 * All the integers in nums appear only once except for precisely one integer which appears two or more times.
 */
public class FindDuplicate {

    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int temp = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(temp == nums[i]) {
                return temp;
            }
            temp = nums[i];
        }
        return -1;
    }

}
