package com.maximilian.interview.common.multithreading;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class FooBarTest {

    @Test
    void fooBar() throws InterruptedException {

        int n = 3;
        FooBar fooBar = new FooBar(n);

        List<String> expected = new ArrayList<>(n * 2);
        for (int i = 0; i < n; i++) {
            expected.add("foo");
            expected.add("bar");
        }
        List<String> result = new CopyOnWriteArrayList<>();

        List<Thread> threads = getThreadList(fooBar, result);
        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            thread.join();
        }

        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }

    }

    private static List<Thread> getThreadList(FooBar fooBar, List<String> result) {
        Thread foo = new Thread(() -> {
            try {
                fooBar.foo(() -> result.add("foo"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread bar = new Thread(() -> {
            try {
                fooBar.bar(() -> result.add("bar"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return List.of(foo, bar);
    }

}