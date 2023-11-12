package com.maximilian.interview.intervals;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals, and return an array of the
 * non-overlapping intervals that cover all the intervals in the input.
 * <p>
 * Constraints:
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(l -> l[0]));
        List<int[]> result = new ArrayList<>(intervals.length);
        for (int i = 0, j = 1; i < intervals.length && j <= intervals.length; j++) {
            if (j < intervals.length && intervals[i][1] >= intervals[j][0]) {
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
            } else {
                result.add(intervals[i]);
                i = j;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

}
