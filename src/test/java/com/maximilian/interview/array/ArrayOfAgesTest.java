package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class ArrayOfAgesTest {

    @Test
    void countPeopleByAge() {
        int[] ages = new int[]{51, 51, 41, 20, 10, 10, 5, 70, 72, 73, 75, 90};

        Map<Integer, Long> expectedResult = Map.of(
                51, 2L, 41, 1L,
                20, 1L, 10, 2L,
                5, 1L, 70, 1L,
                72, 1L, 73, 1L,
                75, 1L, 90, 1L
        );

        Map<Integer, Long> result = ArrayOfAges.countPeopleByAge(ages);

        for(Map.Entry<Integer, Long> entry : expectedResult.entrySet()) {
            Assertions.assertTrue(result.containsKey(entry.getKey()));
            Assertions.assertEquals(entry.getValue(), result.get(entry.getKey()));
        }

    }

}