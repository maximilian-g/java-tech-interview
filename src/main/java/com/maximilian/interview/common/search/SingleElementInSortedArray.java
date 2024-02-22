package com.maximilian.interview.common.search;

/**
 * You are given a sorted array consisting of only integers where
 * every element appears exactly twice, except for one element which appears exactly once.
 * <p>
 * Return the single element that appears only once.
 * <p>
 * Your solution must run in O(log n) time and O(1) space.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^5
 */
public class SingleElementInSortedArray {

    public static int singleNonDuplicate(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex <= rightIndex) {
            int mid = (rightIndex + leftIndex) / 2;
            if (mid > 0 && nums[mid] == nums[mid - 1]) {
                if ((mid - 1) % 2 == 0) {
                    // case when we need to move right
                    leftIndex = mid + 1;
                } else {
                    // need to move left
                    rightIndex = mid - 1;
                }
            } else if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) {
                    // case when we need to move right
                    leftIndex = mid + 1;
                } else {
                    // need to move left
                    rightIndex = mid - 1;
                }

            } else {
                return nums[mid];
            }
        }
        return -1;
    }

}
