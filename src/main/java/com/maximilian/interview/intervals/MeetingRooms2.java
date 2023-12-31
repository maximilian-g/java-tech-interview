package com.maximilian.interview.intervals;

import com.maximilian.interview.intervals.data.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array of meeting time intervals consisting of
 * start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 * <p>
 * NOTE:
 * (0,8),(8,10) is not conflict at 8
 */
public class MeetingRooms2 {

    public static int minMeetingRooms(List<Interval<Integer>> intervals) {
        intervals.sort(Comparator.comparingInt(Interval::getFrom));

        Queue<Interval<Integer>> priorityQueueByToValue = new PriorityQueue<>(
                Comparator.comparingInt(Interval::getTo)
        );

        int minMeetingRooms = 0;
        for (Interval<Integer> interval : intervals) {
            while (!priorityQueueByToValue.isEmpty() &&
                    interval.getFrom() >= priorityQueueByToValue.peek().getTo()) {
                priorityQueueByToValue.poll();
            }
            priorityQueueByToValue.offer(interval);
            minMeetingRooms = Math.max(minMeetingRooms, priorityQueueByToValue.size());
        }

        return minMeetingRooms;
    }

    public static int minMeetingRoomsOld(List<Interval<Integer>> intervals) {
        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++) {
            Interval<Integer> interval = intervals.get(i);
            starts[i] = interval.getFrom();
            ends[i] = interval.getTo();
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int minMeetingRooms = 0;
        int count = 0;
        for (int i = 0, j = 0; i < intervals.size() && j < intervals.size(); ) {
            if (starts[i] < ends[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            minMeetingRooms = Math.max(count, minMeetingRooms);
        }

        return minMeetingRooms;
    }

}
