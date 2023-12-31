package com.maximilian.interview.intervals;

import com.maximilian.interview.intervals.data.Interval;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MeetingRoomsTest {

    @Test
    void canAttendMeetings() {
        List<Interval<Integer>> intervals = new ArrayList<>();
        intervals.add(new Interval<>(0, 30));
        intervals.add(new Interval<>(5, 10));
        intervals.add(new Interval<>(15, 20));

        Assertions.assertFalse(MeetingRooms.canAttendMeetings(intervals));

        intervals.clear();
        intervals.add(new Interval<>(5, 8));
        intervals.add(new Interval<>(9, 15));

        Assertions.assertTrue(MeetingRooms.canAttendMeetings(intervals));

        intervals.clear();
        intervals.add(new Interval<>(5, 8));
        intervals.add(new Interval<>(8, 10));

        Assertions.assertTrue(MeetingRooms.canAttendMeetings(intervals));

        intervals.clear();
        intervals.add(new Interval<>(5, 8));

        Assertions.assertTrue(MeetingRooms.canAttendMeetings(intervals));

        intervals.clear();

        Assertions.assertTrue(MeetingRooms.canAttendMeetings(intervals));

    }

}