package com.maximilian.interview.intervals;

import java.time.LocalTime;

/**
 * You are given two arrays of strings that represent two inclusive events that
 * happened on the same day, event1 and event2, where:
 * <p>
 * event1 = [startTime1, endTime1] and
 * event2 = [startTime2, endTime2].
 * Event times are valid 24 hours format in the form of HH:MM.
 * <p>
 * A conflict happens when two events have some non-empty intersection
 * (i.e., some moment is common to both events).
 * <p>
 * Return true if there is a conflict between two events. Otherwise, return false.
 * <p>
 * Constraints:
 * <p>
 * evnet1.length == event2.length == 2.
 * event1[i].length == event2[i].length == 5
 * startTime1 <= endTime1
 * startTime2 <= endTime2
 * All the event times follow the HH:MM format.
 */
public class EventIntersection {

    public static boolean haveConflict(String[] event1, String[] event2) {
        LocalTime event1Start = LocalTime.parse(event1[0]);
        LocalTime event1End = LocalTime.parse(event1[1]);

        LocalTime event2Start = LocalTime.parse(event2[0]);
        LocalTime event2End = LocalTime.parse(event2[1]);

        return (event1Start.isAfter(event2Start) && event1Start.isBefore(event2End)) ||
                (event1End.isAfter(event2Start) && event1End.isBefore(event2End)) ||
                (event2Start.isAfter(event1Start) && event2Start.isBefore(event1End)) ||
                (event2End.isAfter(event1Start) && event2End.isBefore(event1End)) ||
                event1Start.equals(event2Start) || event1Start.equals(event2End) ||
                event1End.equals(event2Start) || event1End.equals(event2End);
    }

}
