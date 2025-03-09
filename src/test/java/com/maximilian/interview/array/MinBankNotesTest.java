package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinBankNotesTest {

    @Test
    void minBankNotes() {

        int[] bankNotes = {100, 200, 50, 20};
        int targetAmount = 370;
        Assertions.assertEquals(4, MinBankNotes.minBankNotes(bankNotes, targetAmount));

        targetAmount = 470;
        Assertions.assertEquals(4, MinBankNotes.minBankNotes(bankNotes, targetAmount));

        targetAmount = 471;
        Assertions.assertEquals(-1, MinBankNotes.minBankNotes(bankNotes, targetAmount));

        bankNotes = new int[]{20, 30, 60};
        targetAmount = 100;
        Assertions.assertEquals(3, MinBankNotes.minBankNotes(bankNotes, targetAmount));

    }

}