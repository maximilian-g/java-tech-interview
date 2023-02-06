package com.maximilian.interview.array;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CommonItemsInside2Arrays {

    /**
     * Given 2 lists, create a method
     * that lets a user know if there is something in common(any same items in the both lists)
     *
     * Solution below has following properties:
     * Space complexity: O(n)
     * Time complexity:  O(n)
     */
    public static boolean areCommonItemsPresent(List<String> left, List<String> right) {
        Objects.requireNonNull(left, "Left input list cannot be null");
        Objects.requireNonNull(right, "Right input list cannot be null");
        List<String> smallerList = left.size() > right.size() ? right : left;
        List<String> biggerList = left.size() > right.size() ? left : right;
        Set<String> set = new HashSet<>(smallerList);

        for (String s : biggerList) {
            if (set.contains(s)) {
                return true;
            }
        }

        return false;
    }

}
