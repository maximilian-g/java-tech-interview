package com.maximilian.interview.stack;

import java.util.PriorityQueue;

/**
 * You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].
 * <p>
 * Implement the SmallestInfiniteSet class:
 * <p>
 * SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
 * int popSmallest() Removes and returns the smallest integer contained in the infinite set.
 * void addBack(int num) Adds a positive integer num back into the infinite set,
 * if it is not already in the infinite set.
 * <p>
 * Constraints:
 * <p>
 * 1 <= num <= 1000
 * At most 1000 calls will be made in total to popSmallest and addBack.
 */
public class SmallestInfiniteSet {

    private int currentInteger = 1;
    private final PriorityQueue<Integer> priorityQueue;

    public SmallestInfiniteSet() {
        priorityQueue = new PriorityQueue<>();
        priorityQueue.add(currentInteger);
    }

    public int popSmallest() {
        int res = priorityQueue.poll();
        if (res == currentInteger) {
            currentInteger++;
            priorityQueue.add(currentInteger);
        }
        return res;
    }

    public void addBack(int num) {
        if (num < currentInteger && !priorityQueue.contains(num)) {
            priorityQueue.add(num);
        }
    }

}
