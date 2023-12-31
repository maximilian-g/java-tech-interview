package com.maximilian.interview.intervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EventIntersectionTest {

    @Test
    void haveConflict() {

        String[] firstEvent = {"01:15", "02:00"};
        String[] secondEvent = {"02:00", "03:00"};

        Assertions.assertTrue(EventIntersection.haveConflict(firstEvent, secondEvent));

        firstEvent = new String[]{"01:00", "02:00"};
        secondEvent = new String[]{"01:20", "03:00"};

        Assertions.assertTrue(EventIntersection.haveConflict(firstEvent, secondEvent));

        firstEvent = new String[]{"10:00", "11:00"};
        secondEvent = new String[]{"14:00", "15:00"};

        Assertions.assertFalse(EventIntersection.haveConflict(firstEvent, secondEvent));

    }

}