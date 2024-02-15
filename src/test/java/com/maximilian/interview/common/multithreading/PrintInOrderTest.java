package com.maximilian.interview.common.multithreading;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class PrintInOrderTest {

    @Test
    void printInOrder() throws Exception {
        PrintInOrder test = new PrintInOrder();

        List<String> expected = List.of("First", "Second", "Third");
        List<String> result = new CopyOnWriteArrayList<>();

        List<Thread> threads = List.of(new Thread(() -> {
                    try {
                        test.first(() -> result.add("First"));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }),
                new Thread(() -> {
                    try {
                        test.second(() -> result.add("Second"));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }),
                new Thread(() -> {
                    try {
                        test.third(() -> result.add("Third"));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
        );

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            thread.join();
        }

        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }

    }

}