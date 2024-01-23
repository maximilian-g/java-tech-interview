package com.maximilian.interview.queue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a characters array tasks, representing the tasks a CPU needs to do,
 * where each letter represents a different task. Tasks could be done in any order.
 * Each task is done in one unit of time. For each unit of time,
 * the CPU could complete either one task or just be idle.
 * <p>
 * However, there is a non-negative integer n that represents the cooldown period
 * between two same tasks (the same letter in the array),
 * that is that there must be at least n units of time between any two same tasks.
 * <p>
 * Return the least number of units of times that the CPU will take to finish all the given tasks.
 * <p>
 * Constraints:
 * <p>
 * 1 <= task.length <= 10^4
 * tasks[i] is upper-case English letter.
 * The integer n is in the range [0, 100].
 */
public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        int result = 0;
        Map<Character, TaskData> taskQuantityMap = new HashMap<>();
        for (char task : tasks) {
            TaskData currentTask = taskQuantityMap
                    .getOrDefault(task, new TaskData(task, 0, 0));
            currentTask.setQuantity(currentTask.quantity + 1);
            taskQuantityMap.put(task, currentTask);
        }
        Queue<TaskData> taskDataQueue = new PriorityQueue<>(Comparator.reverseOrder());
        taskDataQueue.addAll(taskQuantityMap.values());

        while (!taskDataQueue.isEmpty()) {
            TaskData data = taskDataQueue.poll();
            if (data.cooldown == 0) {
                data.quantity--;
                data.cooldown = n;
            } else {
                data.cooldown--;
            }
            result++;

            List<TaskData> taskData = taskDataQueue.stream().toList();
            taskData.forEach(task -> task.setCooldown(Math.max(0, task.cooldown - 1)));
            taskDataQueue.clear();
            taskDataQueue.addAll(taskData);
            if (data.quantity > 0) {
                taskDataQueue.add(data);
            }
        }
        return result;
    }

    private static class TaskData implements Comparable<TaskData> {
        protected char task;
        protected int cooldown;
        protected int quantity;

        private TaskData(char task, int cooldown, int quantity) {
            this.task = task;
            this.cooldown = cooldown;
            this.quantity = quantity;
        }

        public char getTask() {
            return task;
        }

        public TaskData setTask(char task) {
            this.task = task;
            return this;
        }

        public int getCooldown() {
            return cooldown;
        }

        public TaskData setCooldown(int cooldown) {
            this.cooldown = cooldown;
            return this;
        }

        public int getQuantity() {
            return quantity;
        }

        public TaskData setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        @Override
        public int compareTo(TaskData o) {
            int result = Integer.compare(
                    o.cooldown,
                    cooldown
            );
            if (result == 0) {
                return Integer.compare(quantity, o.quantity);
            }
            return result;
        }
    }

}
