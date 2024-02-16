package com.maximilian.interview.array;

import java.util.Arrays;

/**
 * There is a function signFunc(x) that returns:
 * <p>
 * 1 if x is positive.
 * -1 if x is negative.
 * 0 if x is equal to 0.
 * You are given an integer array nums. Let product be the product of all values in the array nums.
 * <p>
 * Return signFunc(product).
 */
public class SignOfTheProductOfAnArray {

    public static int arraySign(int[] nums) {
        return Arrays.stream(nums).reduce(1, (l, r) -> l * Integer.compare(r, 0));
    }

}
