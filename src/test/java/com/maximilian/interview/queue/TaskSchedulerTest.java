package com.maximilian.interview.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskSchedulerTest {

    @Test
    void leastInterval() {

        Assertions.assertEquals(8, TaskScheduler.leastInterval(
                new char[]{'A', 'A', 'A', 'B', 'B', 'B'},
                2
        ));
        Assertions.assertEquals(6, TaskScheduler.leastInterval(
                new char[]{'A', 'A', 'A', 'B', 'B', 'B'},
                0
        ));
        Assertions.assertEquals(16, TaskScheduler.leastInterval(
                new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'},
                2
        ));

    }

}