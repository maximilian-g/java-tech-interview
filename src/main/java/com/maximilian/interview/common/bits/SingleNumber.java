package com.maximilian.interview.common.bits;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one.
 * Find that single one.
 * <p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 */
public class SingleNumber {

    /**
     * Explanation:
     * The question simply asks us to find an element in the given array whose frequency is 1.
     * All the other elements have a frequency=2.
     * According to XOR(^), the output is true, only if both the inputs are of opposite kind.
     * A^A=0
     * A^B^B^A=0
     * A^B^A=B
     * If number A occurs even times(2 in our case), then it will be 0, otherwise it will be A
     */
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

}
