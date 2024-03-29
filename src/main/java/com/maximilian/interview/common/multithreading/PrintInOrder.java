package com.maximilian.interview.common.multithreading;

import java.util.concurrent.Semaphore;

/**
 * Suppose we have a class:
 * <p>
 * public class Foo {
 * public void first() { print("first"); }
 * public void second() { print("second"); }
 * public void third() { print("third"); }
 * }
 * The same instance of Foo will be passed to three different threads.
 * Thread A will call first(), thread B will call second(), and thread C will call third().
 * Design a mechanism and modify the program to ensure that second() is executed after first(),
 * and third() is executed after second().
 * <p>
 * Note:
 * <p>
 * We do not know how the threads will be scheduled in the operating system,
 * even though the numbers in the input seem to imply the ordering.
 * The input format you see is mainly to ensure our tests' comprehensiveness.
 */
public class PrintInOrder {

    private final Semaphore secondLock = new Semaphore(0);
    private final Semaphore thirdLock = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        secondLock.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        secondLock.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        thirdLock.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        thirdLock.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}
