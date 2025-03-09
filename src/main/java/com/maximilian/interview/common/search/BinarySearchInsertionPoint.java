package com.maximilian.interview.common.search;

/**
 * <a href="https://leetcode.com/problems/search-insert-position/description/">Link to a task</a>
 * <p>
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class BinarySearchInsertionPoint {

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int midIndex = ((right - left) / 2) + left;
            if (nums[midIndex] > target) {
                right = midIndex - 1;
            } else if (nums[midIndex] < target) {
                left = midIndex + 1;
            } else {
                return midIndex;
            }
        }
        return left;
    }

}
