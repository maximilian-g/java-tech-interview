package com.maximilian.interview.common;

import java.util.PriorityQueue;

/**
 * You are given an array of integers nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 * <p>
 * Return the max sliding window.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i <= nums.length - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                max = Math.max(nums[i + j], max);
            }
            res[i] = max;
        }

        return res;
    }

    public static int[] maxSlidingWindowImproved(int[] nums, int k) {
        if (k <= 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> (o2 - o1));

        for (int i = 0; i < nums.length; i++) {
            // if size == k - remove first
            if (queue.size() == k) {
                queue.remove(nums[i - k]);
            }
            // add new
            queue.offer(nums[i]);
            // add max to res
            if (queue.size() == k) {
                res[i - k + 1] = queue.peek();
            }
        }

        return res;
    }

}
