package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BankTest {

    @Test
    void simpleTest() {

        Bank bank = new Bank(new long[]{10, 100, 20, 50, 30});
        Assertions.assertTrue(bank.withdraw(3, 10));
        Assertions.assertTrue(bank.transfer(5, 1, 20));
        Assertions.assertTrue(bank.deposit(5, 20));
        Assertions.assertFalse(bank.transfer(3, 4, 15));
        Assertions.assertFalse(bank.withdraw(10, 50));

    }

}