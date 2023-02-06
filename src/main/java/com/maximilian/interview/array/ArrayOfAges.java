package com.maximilian.interview.array;

import java.util.HashMap;
import java.util.Map;

/**
 * We have a very long array of people ages.
 * Need to count amount of people by each age.
 */
public class ArrayOfAges {

    public static Map<Integer, Long> countPeopleByAge(int[] ages) {
        Map<Integer, Long> result = new HashMap<>();
        for (int age : ages) {
            result.put(age, result.getOrDefault(age, 0L) + 1);
        }
        return result;
    }

}
