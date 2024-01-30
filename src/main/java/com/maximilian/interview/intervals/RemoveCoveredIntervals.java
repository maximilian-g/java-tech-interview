package com.maximilian.interview.intervals;


import java.util.Arrays;

/**
 * Given an array intervals where intervals[i] = [li, ri]
 * represent the interval [li, ri), remove all intervals that are covered by another interval in the list.
 * <p>
 * The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.
 * <p>
 * Return the number of remaining intervals.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,4],[3,6],[2,8]]
 * Output: 2
 * Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
 * Example 2:
 * <p>
 * Input: intervals = [[1,4],[2,3]]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= intervals.length <= 1000
 * intervals[i].length == 2
 * 0 <= li < ri <= 10^5
 * All the given intervals are unique.
 */
public class RemoveCoveredIntervals {

    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (l, r) -> {
            int result = Integer.compare(l[0], r[0]);
            // start values are equal case, comparing by end value desc
            if (result == 0) {
                return Integer.compare(r[1], l[1]);
            }
            return result;
        });

        int remaining = intervals.length;
        int[] currentInterval = null;

        for (int[] interval : intervals) {
            if (currentInterval == null) {
                currentInterval = interval;
            } else if (currentInterval[1] >= interval[1]) {
                remaining--;
            } else {
                currentInterval = interval;
            }
        }

        return remaining;
    }

}
