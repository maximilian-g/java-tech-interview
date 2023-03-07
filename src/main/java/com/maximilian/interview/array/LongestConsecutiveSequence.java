package com.maximilian.interview.array;

import java.util.Set;
import java.util.TreeSet;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */
public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxConsecutiveSeq = 0;
        int currentConsecutiveSeq = 0;
        int prev = Integer.MIN_VALUE;
        for (int num : set) {
            if (prev == Integer.MIN_VALUE) {
                currentConsecutiveSeq++;
                prev = num;
            } else {
                int diff = num - prev;
                prev = num;
                if (diff > 1) {
                    // start new sequence from 1
                    currentConsecutiveSeq = 1;
                } else if (diff == 1) {
                    // increase current sequence
                    currentConsecutiveSeq++;
                }
                // < 1 impossible, because of Set
            }
            maxConsecutiveSeq = Math.max(currentConsecutiveSeq, maxConsecutiveSeq);
        }

        return maxConsecutiveSeq;
    }

}
