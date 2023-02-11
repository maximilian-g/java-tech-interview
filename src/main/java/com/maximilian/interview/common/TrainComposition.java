package com.maximilian.interview.common;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * A TrainComposition is built by attaching and detaching wagons from the left and from the right sides.
 * <p>
 * For example if we start by attaching wagon 7 from the left followed by attaching wagon 13
 * from the left, we get a composition of wagons: 7, 13(from left to right)
 * <p>
 * Implement a train composition that models that problem
 */
public class TrainComposition {

    private final Deque<Integer> wagons = new ArrayDeque<>();

    public void addLeft(int wagonId) {
        wagons.addFirst(wagonId);
    }

    public void addRight(int wagonId) {
        wagons.addLast(wagonId);
    }

    // could throw exception, it's ok
    public int removeLeft() {
        return wagons.removeFirst();
    }

    // could throw exception, it's ok
    public int removeRight() {
        return wagons.removeLast();
    }

    public List<Integer> currentComposition() {
        return new ArrayList<>(wagons);
    }

}
