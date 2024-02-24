package com.maximilian.interview.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SeatReservationManagerTest {

    @Test
    void reserveAndUnreserve() {

        SeatReservationManager manager = new SeatReservationManager(5);
        Assertions.assertEquals(1, manager.reserve());
        Assertions.assertEquals(2, manager.reserve());
        manager.unreserve(2);
        Assertions.assertEquals(2, manager.reserve());
        Assertions.assertEquals(3, manager.reserve());
        Assertions.assertEquals(4, manager.reserve());
        Assertions.assertEquals(5, manager.reserve());
        manager.unreserve(5);

    }

}