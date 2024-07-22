package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SortPeopleTest {

    @Test
    void sortPeople() {
        String[] names = {
                "Mary", "John", "Emma"
        };
        int[] heights = {
                180, 165, 170
        };
        String[] actual = SortPeople.sortPeople(names, heights);
        String[] expected = {
                "Mary", "Emma", "John"
        };
        Assertions.assertArrayEquals(expected, actual);
    }

}