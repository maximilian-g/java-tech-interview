package com.maximilian.interview.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 * <p>
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones
 * and smash them together. Suppose the heaviest two stones have weights x and y with x <= y.
 * The result of this smash is:
 * <p>
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.
 * <p>
 * Return the weight of the last remaining stone. If there are no stones left, return 0.
 */
public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            queue.add(stone);
        }
        while (queue.size() > 1) {
            int stoneY = queue.poll();
            int stoneX = queue.poll();

            if (stoneX != stoneY) {
                queue.add(stoneY - stoneX);
            }

        }
        return queue.size() == 0 ? 0 : queue.poll();
    }

}
