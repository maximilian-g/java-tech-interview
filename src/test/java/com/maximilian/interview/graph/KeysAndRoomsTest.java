package com.maximilian.interview.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class KeysAndRoomsTest {

    @Test
    void canVisitAllRooms() {

        List<List<Integer>> input = List.of(
                List.of(1),
                List.of(2),
                List.of(3),
                List.of()
        );
        Assertions.assertTrue(KeysAndRooms.canVisitAllRooms(input));

        input = List.of(
                List.of(1, 3),
                List.of(3, 0, 1),
                List.of(2),
                List.of(0)
        );
        Assertions.assertFalse(KeysAndRooms.canVisitAllRooms(input));

    }

}