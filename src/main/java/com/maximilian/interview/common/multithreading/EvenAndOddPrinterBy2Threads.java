package com.maximilian.interview.common.multithreading;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

public class EvenAndOddPrinterBy2Threads {

    public static void printEvenAndOdd(int upperBound) {
        printEvenAndOdd(upperBound, false);
    }

    public static void printEvenAndOdd(int upperBound, boolean waitForThreads) {
        if (upperBound <= 0) {
            throw new IllegalArgumentException("Bound must be positive number > 0.");
        }

        AtomicInteger initialInteger = new AtomicInteger(1);

        ReentrantLock commonLock = new ReentrantLock();
        Thread even = new Thread(new Printer(initialInteger,
                i -> i % 2 == 0,
                "even",
                commonLock,
                upperBound));
        Thread odd = new Thread(new Printer(initialInteger,
                i -> i % 2 != 0,
                "odd",
                commonLock,
                upperBound));
        even.start();
        odd.start();
        if (waitForThreads) {
            waitFor(List.of(even, odd));
        }
    }

    private static void waitFor(List<Thread> threads) {
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private record Printer(AtomicInteger atomicInteger,
                           Predicate<Integer> integerPredicate, String integerAssignedName,
                           ReentrantLock lock, int upperBound) implements Runnable {

        @Override
        public void run() {
            int currentInteger = 0;
            while (currentInteger < upperBound) {
                try {
                    lock.lock();
                    currentInteger = atomicInteger.get();
                    if (integerPredicate.test(currentInteger)) {
                        System.out.println(Thread.currentThread().getName() +
                                " number " + currentInteger + " is " + integerAssignedName);
                        atomicInteger.incrementAndGet();
                    }
                } finally {
                    lock.unlock();
                }
            }
        }

    }

}
