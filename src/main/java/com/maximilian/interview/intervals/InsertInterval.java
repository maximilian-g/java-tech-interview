package com.maximilian.interview.intervals;


import java.util.ArrayList;
import java.util.List;

import static com.maximilian.interview.intervals.IntervalUtils.fullyIntersects;
import static com.maximilian.interview.intervals.IntervalUtils.intersects;

/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
 * represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
 * <p>
 * You are also given an interval newInterval = [start, end]
 * that represents the start and end of another interval.
 * <p>
 * Insert newInterval into intervals such that intervals is still sorted in
 * ascending order by starti and intervals still does not have any overlapping intervals
 * (merge overlapping intervals if necessary).
 * <p>
 * Return intervals after the insertion.
 * <p>
 * intervals is sorted by starti in ascending order.
 */
public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int insertionIndex = 0;
        int mergeIndex = -1;
        int mergeEndIndex = -1;
        int[][] resultIntervals = new int[intervals.length + 1][];
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] < newInterval[0]) {
                insertionIndex++;
            }
            if (mergeIndex != -1) {
                // compare current with previous, merge if necessary
                int[] prevInterval = intervals[i - 1];
                // [2, 17] [10, 15] [16, 20] [21, 25] ->
                // [2, 17] [2, 17] [16, 20] [21, 25] ->
                // [2, 17] [2, 17] [2, 20] [21, 25] ->
                if (!intersects(interval, prevInterval)) {
                    break;
                }
                interval[0] = prevInterval[0];
                interval[1] = Math.max(interval[1], prevInterval[1]);
                mergeEndIndex = i;
                continue;
            }
            resultIntervals[i] = intervals[i];

            // 1 - new interval intersects fully with current - return initial intervals array
            if (fullyIntersects(interval, newInterval)) {
                return intervals;
            }

            if (newInterval[1] >= interval[0] && newInterval[1] <= interval[1]) {
                // 3 - new interval intersects from right with current - [3, 5] [2, 4],
                // make interval [2, 5] and return intervals
                interval[0] = newInterval[0];
                // since we merged only left part, that means that we do not need to seek further
                // and can return intervals array
                return intervals;
            }

            if (newInterval[0] >= interval[0] && newInterval[0] <= interval[1] ||
                    interval[0] >= newInterval[0] && interval[0] <= newInterval[1]) {
                // 2 - new interval intersects from left with current - [1, 3] [2, 4],
                // make interval [1, 4] and return intervals
                // also we need to merge current interval with other next intervals
                interval[1] = newInterval[1];
                interval[0] = Math.min(interval[0], newInterval[0]);
                mergeIndex = i;
            }
        }

        if (mergeIndex == -1) {
            // 4 - new interval does not intersect with any other - just insert on its place
            // (sorted by start value)
            return insert(intervals, newInterval, insertionIndex);
        } else {
            if (mergeEndIndex == -1) {
                // case where we merged last interval
                return intervals;
            }
            resultIntervals = new int[intervals.length - (mergeEndIndex - mergeIndex)][];
            for (int i = 0, j = 0; i < resultIntervals.length; i++, j++) {
                if (j == mergeIndex) {
                    j = mergeEndIndex;
                }
                resultIntervals[i] = intervals[j];
            }
        }

        return resultIntervals;
    }

    public static int[][] insertOpt(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval == null || interval[1] < newInterval[0]) {
                // case when "newInterval" does not intersect "interval", just inserting
                res.add(interval);
            } else if (interval[0] > newInterval[1]) {
                // case when "newInterval" does not intersect "interval",
                // AND we found place for "newInterval" (before "interval")
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else {
                // case when intervals intersect, merging them
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        // case when interval is on the last place
        if (newInterval != null) {
            res.add(newInterval);
        }
        return res.toArray(new int[0][]);
    }

    private static int[][] insert(int[][] intervals, int[] newInterval, int insertionIndex) {
        int[][] result = new int[intervals.length + 1][];
        for (int i = 0, j = 0; i < result.length; i++) {
            if (insertionIndex == i) {
                result[i] = newInterval;
            } else {
                result[i] = intervals[j++];
            }
        }
        return result;
    }

}
