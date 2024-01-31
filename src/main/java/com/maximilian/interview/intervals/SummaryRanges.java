package com.maximilian.interview.intervals;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Given a data stream input of non-negative
 * integers a1, a2, ..., an, summarize the numbers seen so far as a list of disjoint intervals.
 * <p>
 * Implement the SummaryRanges class:
 * <p>
 * SummaryRanges() Initializes the object with an empty stream.
 * void addNum(int value) Adds the integer value to the stream.
 * int[][] getIntervals() Returns a summary of the integers in
 * the stream currently as a list of disjoint intervals [starti, endi].
 * The answer should be sorted by starti.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals",
 * "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
 * [[], [1], [], [3], [], [7], [], [2], [], [6], []]
 * Output
 * [null, null, [[1, 1]], null, [[1, 1], [3, 3]], null,
 * [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
 * <p>
 * Explanation
 * SummaryRanges summaryRanges = new SummaryRanges();
 * summaryRanges.addNum(1);      // arr = [1]
 * summaryRanges.getIntervals(); // return [[1, 1]]
 * summaryRanges.addNum(3);      // arr = [1, 3]
 * summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
 * summaryRanges.addNum(7);      // arr = [1, 3, 7]
 * summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
 * summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
 * summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
 * summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
 * summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
 * <p>
 * Constraints:
 * <p>
 * 0 <= value <= 10^4
 * At most 3 * 10^4 calls will be made to addNum and getIntervals.
 * At most 10^2 calls will be made to getIntervals.
 */
public class SummaryRanges {

    private final List<int[]> intervals = new LinkedList<>();

    public SummaryRanges() {

    }

    public void addNum(int value) {
        int[] currentInterval = new int[]{value, value};
        if (intervals.isEmpty()) {
            // base case, no intervals
            intervals.add(currentInterval);
            return;
        }
        // searching for index for insertion, our intervals is always sorted by start value
        int result = Collections.binarySearch(intervals,
                currentInterval,
                Comparator.comparingInt(v -> v[0]));
        if (result >= 0) {
            //nothing to insert, because value is already inside start point of some interval
            return;
        }
        int insertionIndex = -result - 1;

        // compare left and right intervals
        Optional<int[]> leftInterval = getIntervalByIndex(insertionIndex - 1);
        Optional<int[]> rightInterval = getIntervalByIndex(insertionIndex);

        boolean insertedInterval = false;
        boolean mergedInterval = false;

        if (leftInterval.isPresent()) {
            int[] leftIntervalValue = leftInterval.get();
            if (value >= leftIntervalValue[0] && value <= leftIntervalValue[1]) {
                // value is fully inside left interval, no need to insert
                return;
            }
            if (Math.abs(value - leftIntervalValue[1]) == 1) {
                leftIntervalValue[1] = Math.max(value, leftIntervalValue[1]);
                currentInterval = leftIntervalValue;
                mergedInterval = true;
            } else {
                intervals.add(insertionIndex, currentInterval);
                insertedInterval = true;
            }
        }

        if (rightInterval.isPresent()) {
            int[] rightIntervalValue = rightInterval.get();
            if (Math.abs(currentInterval[1] - rightIntervalValue[0]) <= 1) {
                rightIntervalValue[0] = currentInterval[0];
                if (leftInterval.isPresent()) {
                    intervals.remove(insertionIndex - (insertedInterval ? 0 : 1));
                }
            } else if (!insertedInterval && !mergedInterval) {
                intervals.add(insertionIndex, currentInterval);
            }
        }

    }

    public int[][] getIntervals() {
        int[][] result = new int[intervals.size()][];
        int i = 0;
        for (int[] interval : intervals) {
            result[i++] = new int[]{interval[0], interval[1]};
        }
        return result;
    }

    private Optional<int[]> getIntervalByIndex(int index) {
        if (index >= 0 && intervals.size() > index) {
            return Optional.of(intervals.get(index));
        }
        return Optional.empty();
    }

}
