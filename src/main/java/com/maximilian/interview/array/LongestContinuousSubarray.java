package com.maximilian.interview.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given an array of integers nums and an integer limit,
 * return the size of the longest non-empty subarray such
 * that the absolute difference between any two elements of
 * this subarray is less than or equal to limit.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [8,2,4,7], limit = 4
 * Output: 2
 * Explanation: All subarrays are:
 * [8] with maximum absolute diff |8-8| = 0 <= 4.
 * [8,2] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
 * [2] with maximum absolute diff |2-2| = 0 <= 4.
 * [2,4] with maximum absolute diff |2-4| = 2 <= 4.
 * [2,4,7] with maximum absolute diff |2-7| = 5 > 4.
 * [4] with maximum absolute diff |4-4| = 0 <= 4.
 * [4,7] with maximum absolute diff |4-7| = 3 <= 4.
 * [7] with maximum absolute diff |7-7| = 0 <= 4.
 * Therefore, the size of the longest subarray is 2.
 * Example 2:
 * <p>
 * Input: nums = [10,1,2,4,7,2], limit = 5
 * Output: 4
 * Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
 * Example 3:
 * <p>
 * Input: nums = [4,2,2,2,4,4,2,2], limit = 0
 * Output: 3
 */
public class LongestContinuousSubarray {

    public static int longestSubarray(int[] nums, int limit) {
        int res = -1;
        int minIndex;
        int maxIndex;
        // comparator avoids last iteration index out of bounds case
        TreeMap<Integer, List<Integer>> indexByValueMap = new TreeMap<>();
        indexByValueMap.put(nums[0], new ArrayList<>(List.of(0)));
        for (int i = 0, j = 0; i <= j && i < nums.length && j < nums.length; ) {
            minIndex = indexByValueMap.get(indexByValueMap.firstKey()).get(0);
            maxIndex = indexByValueMap.get(indexByValueMap.lastKey()).get(0);
            if (nums[maxIndex] - nums[minIndex] <= limit) {
                res = Math.max(j - i + 1, res);
                j++;
                if (nums.length > j) {
                    addSingleValueToKey(indexByValueMap, nums[j], j);
                }
            } else {
                if (i == j) {
                    j++;
                    if (nums.length > j) {
                        addSingleValueToKey(indexByValueMap, nums[j], j);
                    }
                }
                indexByValueMap.get(nums[i]).remove(0);
                if (indexByValueMap.get(nums[i]).isEmpty()) {
                    indexByValueMap.remove(nums[i]);
                }
                i++;
            }
        }
        return res;
    }

    private static void addSingleValueToKey(Map<Integer, List<Integer>> map, int key, int singleValue) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(singleValue);
    }

}
