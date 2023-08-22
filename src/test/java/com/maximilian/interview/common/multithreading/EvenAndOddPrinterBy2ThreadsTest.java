package com.maximilian.interview.common.multithreading;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EvenAndOddPrinterBy2ThreadsTest {

    @Test
    void printEvenAndOdd() {


        Assertions.assertThrows(IllegalArgumentException.class,
                () -> EvenAndOddPrinterBy2Threads.printEvenAndOdd(0));


        EvenAndOddPrinterBy2Threads.printEvenAndOdd(1, true);
        System.out.println("\n");
        EvenAndOddPrinterBy2Threads.printEvenAndOdd(2, true);
        System.out.println("\n");
        EvenAndOddPrinterBy2Threads.printEvenAndOdd(10, true);

    }

}