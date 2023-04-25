package com.maximilian.interview.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BlockingQueueTest {

    @Test
    void put() throws InterruptedException {
        BlockingQueue<Integer> test = new BlockingQueue<>();
        test.put(1);
        test.put(2);
        Assertions.assertEquals(1, test.take());
        Assertions.assertEquals(2, test.take());
    }

    @Test
    void take() throws InterruptedException {

        BlockingQueue<Integer> test = new BlockingQueue<>();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            test.put(100);
        }).start();

        // current thread should wait until started thread will add a 100 into queue
        Assertions.assertEquals(100, test.take());

    }

}