package com.maximilian.interview.intervals;

import com.maximilian.interview.intervals.data.Interval;

import java.util.Comparator;
import java.util.List;

/**
 * Given an array of meeting time intervals consisting of
 * start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 * <p>
 * Example 1
 * <p>
 * Input: intervals = [(0,30),(5,10),(15,20)]
 * Output: false
 * Explanation:
 * (0,30), (5,10) and (0,30),(15,20) will conflict
 * <p>
 * Example 2
 * <p>
 * Input: intervals = [(5,8),(9,15)]
 * Output: true
 * Explanation:
 * Two times will not conflict
 * <p>
 * NOTE:
 * [0,8],[8,10] is not conflict at 8
 */
public class MeetingRooms {

    // O(n * logn) solution
    public static boolean canAttendMeetings(List<Interval<Integer>> intervals) {
        intervals.sort(Comparator.comparing(Interval::getFrom));
        Interval<Integer> prevInterval = null;
        for (Interval<Integer> interval : intervals) {
            // intersection case
            if (prevInterval != null && prevInterval.getTo() > interval.getFrom()) {
                return false;
            }
            prevInterval = interval;
        }
        return true;
    }

}
