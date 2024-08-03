package com.maximilian.interview.common.search;

/**
 * <a href="https://leetcode.com/problems/find-peak-element">
 * Link to a task</a>
 * <p>
 * A peak element is an element that is strictly greater than its neighbors.
 * <p>
 * Given a 0-indexed integer array nums, find a peak element, and return its index.
 * If the array contains multiple peaks, return the index to any of the peaks.
 * <p>
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element
 * is always considered to be strictly greater than a neighbor that is outside the array.
 * <p>
 * You must write an algorithm that runs in O(log n) time.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 1000
 * -2^31 <= nums[i] <= 2^31 - 1
 * nums[i] != nums[i + 1] for all valid i.
 */
public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length;
        while (end >= start) {
            int mid = start + (end - start) / 2;
            int midLeft = mid == 0 ? Integer.MIN_VALUE : nums[mid - 1];
            int midRight = mid == nums.length - 1 ? Integer.MIN_VALUE : nums[mid + 1];
            if ((nums[mid] > midLeft || midLeft == Integer.MIN_VALUE) &&
                    (nums[mid] > midRight || midRight == Integer.MIN_VALUE)) {
                return mid;
            }
            if (midRight > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}
