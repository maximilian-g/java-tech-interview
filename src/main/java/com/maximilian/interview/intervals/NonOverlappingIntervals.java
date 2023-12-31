package com.maximilian.interview.intervals;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of intervals 'intervals' where intervals[i] = [start i, end i],
 * return the minimum number of intervals you need to remove to make the
 * rest of the intervals non-overlapping.
 * <p>
 * NOTE: intervals are not overlapping having the same start i or end i, example:
 * [1, 2], [2, 3] are not overlapping
 * </p>
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 * <p>
 * Example 2:
 * <p>
 * Input: intervals = [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
 * <p>
 * Example 3:
 * <p>
 * Input: intervals = [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= intervals.length <= 10^5
 * intervals[i].length == 2
 * -5 * 10^4 <= start i < end i <= 5 * 10^4
 */
public class NonOverlappingIntervals {

    /**
     * Description (O(n * logn) solution):
     * We will sort all intervals by start value,
     * then we will iterate though intervals and check intersection.
     * In case of intersection - 'intervalsToRemove' incremented, prevIntervalEnd = min value of end values
     * In case of no intersection - no increment, prevIntervalEnd = max value of end values
     * Picking min value in case of intersection -
     * in case of intersection all following intervals will have less chance to intersect with
     * interval which end value is less than other interval's end value
     * <p>
     * Example:
     * <p>
     * [[1,2],[1,4],[2,3],[3,5]]
     * Iteration 1 - we will pick '2' as end interval value
     * Iteration 2 - we will have intersection with [1,4] and prevIntervalEnd will stay 2,
     * so [1,4] is 'removed', 'intervalsToRemove' incremented
     * Iteration 3 - we will have no intersection with [2,3] and prevIntervalEnd will be 3,
     * Iteration 4 - we will have no intersection with [3,5] and prevIntervalEnd will be 5,
     * then we will return 'intervalsToRemove' value which will be '1'
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(v -> v[0]));
        int prevIntervalEnd = Integer.MIN_VALUE;
        int intervalsToRemove = 0;
        for (int[] interval : intervals) {
            if (prevIntervalEnd > interval[0]) {
                // intersection case, need to take min end value
                prevIntervalEnd = Math.min(interval[1], prevIntervalEnd);
                intervalsToRemove++;
            } else {
                // not intersection case, need to take max end value
                prevIntervalEnd = Math.max(interval[1], prevIntervalEnd);
            }
        }
        return intervalsToRemove;
    }

}
