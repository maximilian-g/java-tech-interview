package com.maximilian.interview.common;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * You are given an array of strings names, and an array heights that consists of
 * distinct positive integers. Both arrays are of length n.
 * <p>
 * For each index i, names[i] and heights[i] denote the name and height of the ith person.
 * <p>
 * Return names sorted in descending order by the people's heights.
 * <a href="https://leetcode.com/problems/sort-the-people">Link to a task</a>
 */
public class SortPeople {

    public static String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        return map.values().toArray(new String[0]);
    }

}
