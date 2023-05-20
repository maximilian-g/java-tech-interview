package com.maximilian.interview.stack;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * There are n cars going to the same destination along a one-lane road. The destination is target miles away.
 * <p>
 * You are given two integer array position and speed, both of length n, where position[i]
 * is the position of the ith car and speed[i] is the speed of the ith car (in miles per hour).
 * <p>
 * A car can never pass another car ahead of it, but it can catch up to it
 * and drive bumper to bumper at the same speed. The faster car will slow down to match the slower car's speed.
 * The distance between these two cars is ignored (i.e., they are assumed to have the same position).
 * <p>
 * A car fleet is some non-empty set of cars driving at the same position and same speed.
 * Note that a single car is also a car fleet.
 * <p>
 * If a car catches up to a car fleet right at the destination point,
 * it will still be considered as one car fleet.
 * <p>
 * Return the number of car fleets that will arrive at the destination.
 * <p>
 * Constraints:
 * <p>
 * n == position.length == speed.length
 * 1 <= n <= 10^5
 * 0 < target <= 10^6
 * 0 <= position[i] < target
 * All the values of position are unique.
 * 0 < speed[i] <= 10^6
 */
public class CarFleet {

    public static int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> positionSpeedMap = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < position.length; i++) {
            positionSpeedMap.put(position[i], speed[i]);
        }
        int carFleets = 0;
        double slowestTime = 0;

        for (int pos : positionSpeedMap.keySet()) {
            int speedVal = positionSpeedMap.get(pos);
            int rangeToTarget = target - pos;
            double time = (double) (rangeToTarget) / speedVal;
            if (slowestTime < time) {
                slowestTime = time;
                carFleets++;
            }
        }

        return carFleets;
    }

}
