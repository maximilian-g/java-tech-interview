package com.maximilian.interview.common;

import java.util.Arrays;

/**
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * <p>
 * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 */
public class FirstMissingPositive {

    // O(n) complexity, O(n) space,
    // using idea that there can be max nums.length
    // consequent numbers, any element < 1 and > nums.length is ignored
    // and 1 <= nums.length <= 10^5
    public static int firstMissingPositiveV2(int[] nums) {
        int n = nums.length;
        boolean[] exists = new boolean[n];
        for (int num : nums) {
            if (num > 0 && num <= n) {
                exists[num - 1] = true;
            }
        }
        for (int i = 0; i < exists.length; i++) {
            if (!exists[i]) {
                return i + 1;
            }
        }
        return n + 1;
    }

    // O(n) complexity, O(1) space
    public static int firstMissingPositiveV3(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return nums.length + 1;
    }

    // O(n*logn) complexity, O(1) space, but ugly solution
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length - 1] <= 0) {
            return 1;
        }
        int result = 1;
        boolean resultChanged = false;
        boolean wasOneUsed = false;
        for (int num : nums) {
            if (num > 0) {
                if (num == 1) {
                    wasOneUsed = true;
                } else if (num - result <= 1) {
                    result = num;
                    resultChanged = true;
                } else {
                    if (!resultChanged && !wasOneUsed) {
                        return result;
                    }
                    break;
                }
            }
        }
        if (!wasOneUsed) {
            return 1;
        }
        return result + 1;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
