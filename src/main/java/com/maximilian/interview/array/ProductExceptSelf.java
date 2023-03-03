package com.maximilian.interview.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return an array answer such that answer[i]
 * is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time.
 */
public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int product = 1;
        Set<Integer> zerosIndices = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // skip zeros multiplication
            if(nums[i] == 0) {
                zerosIndices.add(i);
                continue;
            }
            product *= nums[i];
        }
        // everything is 0, 2 or more zeros present
        if(zerosIndices.size() > 1) {
            return result;
        }
        for(int i = 0; i < nums.length; i++) {
            if(zerosIndices.contains(i)) {
                result[i] = product;
            } else if (zerosIndices.size() == 0) {
                result[i] = product / nums[i];
            } else {
                // if current value is not zero, but we have zeros, result[i] will be 0
                // default value will be 0, but this is just to make it more clear
                result[i] = 0;
            }
        }
        return result;
    }

}
