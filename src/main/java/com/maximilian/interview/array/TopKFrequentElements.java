package com.maximilian.interview.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 */
public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, ValueFrequency> frequencyMap = new HashMap<>();
        for (int num : nums) {
            if (frequencyMap.containsKey(num)) {
                frequencyMap.get(num).frequency++;
            } else {
                ValueFrequency vf = new ValueFrequency();
                vf.value = num;
                vf.frequency = 1;
                frequencyMap.put(num, vf);
            }
        }

        return frequencyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(k)
                .mapToInt(v -> v.getValue().value)
                .toArray();
    }

    private static class ValueFrequency implements Comparable<ValueFrequency> {
        private int value;
        private int frequency;

        @Override
        public int compareTo(ValueFrequency o) {
            return Integer.compare(o.frequency, frequency);
        }

    }

}
