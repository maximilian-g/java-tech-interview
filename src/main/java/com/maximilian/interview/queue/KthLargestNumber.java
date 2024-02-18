package com.maximilian.interview.queue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You are given an array of strings nums and an integer k.
 * Each string in nums represents an integer without leading zeros.
 * <p>
 * Return the string that represents the kth largest integer in nums.
 * <p>
 * Note: Duplicate numbers should be counted distinctly.
 * For example, if nums is ["1","2","2"], "2" is the first largest integer,
 * "2" is the second-largest integer, and "1" is the third-largest integer.
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= nums.length <= 10^4
 * 1 <= nums[i].length <= 100
 * nums[i] consists of only digits.
 * nums[i] will not have any leading zeros.
 */
public class KthLargestNumber {

    public static String kthLargestNumber(String[] nums, int k) {
        Queue<String> queue = new PriorityQueue<>((l, r) -> {
            int result = Integer.compare(r.length(), l.length());
            // length of strings are the same, then compare by value
            if (result == 0) {
                return compareStringsAsNumbers(l, r);
            }
            return result;
        });
        queue.addAll(Arrays.asList(nums));
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }

        // nums.length always >= k
        return queue.poll();
    }

    private static int compareStringsAsNumbers(String l, String r) {
        for (int i = 0; i < l.length(); i++) {
            if (l.charAt(i) > r.charAt(i)) {
                return -1;
            }
            if (l.charAt(i) < r.charAt(i)) {
                return 1;
            }
        }
        return 0;
    }

}
