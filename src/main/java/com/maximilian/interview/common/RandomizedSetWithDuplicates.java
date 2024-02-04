package com.maximilian.interview.common;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * RandomizedCollection is a data structure that contains a collection of numbers,
 * possibly duplicates (i.e., a multiset). It should support inserting and removing
 * specific elements and also reporting a random element.
 * <p>
 * Implement the RandomizedCollection class:
 * <p>
 * RandomizedCollection() Initializes the empty RandomizedCollection object.
 * <p>
 * bool insert(int val) Inserts an item val into the multiset, even if the item is already present.
 * Returns true if the item is not present, false otherwise.
 * <p>
 * bool remove(int val) Removes an item val from the multiset if present.
 * Returns true if the item is present, false otherwise.
 * Note that if val has multiple occurrences in the multiset, we only remove one of them.
 * <p>
 * int getRandom() Returns a random element from the current multiset of elements.
 * The probability of each element being returned is linearly related to the
 * number of the same values the multiset contains.
 * <p>
 * You must implement the functions of the class such that each function works
 * on average O(1) time complexity.
 * <p>
 * Note: The test cases are generated such that getRandom will only be
 * called if there is at least one item in the RandomizedCollection.
 * <p>
 * Constraints:
 * <p>
 * -2^31 <= val <= 2^31 - 1
 * At most 2 * 10^5 calls in total will be made to insert, remove, and getRandom.
 * There will be at least one element in the data structure when getRandom is called.
 */
public class RandomizedSetWithDuplicates {

    private final List<Integer> valuesList = new ArrayList<>();
    private final Map<Integer, Queue<Integer>> indexByValueMap = new HashMap<>();
    private static final Random random = new Random();

    public RandomizedSetWithDuplicates() {

    }

    public boolean insert(int val) {
        if (indexByValueMap.containsKey(val)) {
            Queue<Integer> indexes = indexByValueMap.get(val);
            indexes.add(valuesList.size());
            valuesList.add(val);
            return false;
        }
        Queue<Integer> indexes = new PriorityQueue<>(Comparator.reverseOrder());
        indexes.add(valuesList.size());
        indexByValueMap.put(val, indexes);
        valuesList.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (!indexByValueMap.containsKey(val)) {
            return false;
        }

        int lastValueIndex = valuesList.size() - 1;
        int lastValue = valuesList.get(lastValueIndex);

        Queue<Integer> indexesOfVal = indexByValueMap.get(val);
        int index = indexesOfVal.poll();
        if (indexesOfVal.isEmpty()) {
            indexByValueMap.remove(val);
        }
        valuesList.remove(valuesList.size() - 1);
        if (lastValue != val) {
            valuesList.set(index, lastValue);
            indexByValueMap.get(lastValue).removeIf(v -> v == lastValueIndex);
            indexByValueMap.get(lastValue).add(index);
        }

        return true;
    }

    public int getRandom() {
        // it is guaranteed that getRandom will be called with at least 1 element
        return valuesList.get(random.nextInt(valuesList.size()));
    }

}
