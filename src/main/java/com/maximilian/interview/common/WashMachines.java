package com.maximilian.interview.common;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * There is a laundry with N washing machines.
 * There is a queue of M people to use washing machines.
 * Only 1 person can use washing machine at the moment.
 * We know how much time will spend each person using washing machine.
 * Person in queue chooses first free washing machine
 * Model this situation, how much time is needed for persons to use washing machines.
 */
public class WashMachines {

    public static int calculateTime(int washingMachinesCount, int[] personsTime) {
        if(washingMachinesCount <= 0 || personsTime.length == 0) {
            return 0;
        }
        Queue<Integer> queue = new PriorityQueue<>(washingMachinesCount, Comparator.comparingInt(value -> value));
        for (int i = 0; i < washingMachinesCount && i < personsTime.length; i++) {
            queue.add(personsTime[i]);
        }

        for (int i = washingMachinesCount; i < personsTime.length; i++) {
            Integer val = queue.poll();
            queue.add(personsTime[i] + val);
        }
        return queue.stream().max(Comparator.comparingInt(value -> value)).orElse(0);
    }

}
