package com.maximilian.interview.intervals;

import com.maximilian.interview.intervals.data.Interval;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class MeetingRooms2Test {

    @Test
    void minMeetingRooms() {

        List<Function<List<Interval<Integer>>, Integer>> methodsToTest = List.of(
                MeetingRooms2::minMeetingRooms,
                MeetingRooms2::minMeetingRoomsOld
        );

        List<Interval<Integer>> intervals = new ArrayList<>();
        intervals.add(new Interval<>(0, 30));
        intervals.add(new Interval<>(5, 10));
        intervals.add(new Interval<>(15, 20));
        int expectedRooms = 2;

        for (Function<List<Interval<Integer>>, Integer> methodToTest : methodsToTest) {
            Assertions.assertEquals(expectedRooms, methodToTest.apply(intervals));
        }

        intervals.clear();
        intervals.add(new Interval<>(5, 7));
        expectedRooms = 1;

        for (Function<List<Interval<Integer>>, Integer> methodToTest : methodsToTest) {
            Assertions.assertEquals(expectedRooms, methodToTest.apply(intervals));
        }

    }

}