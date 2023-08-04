package com.maximilian.interview.common.dp;

/**
 * Given an integer array nums, find a
 * subarray
 * that has the largest product, and return the product.
 * <p>
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */
public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int product = 1;
        for (int val : nums) {
            product *= val;
            res = Math.max(res, product);
            if (product == 0) {
                product = 1;
            }
        }
        product = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            res = Math.max(res, product);
            if (product == 0) {
                product = 1;
            }
        }
        return res;
    }

}
