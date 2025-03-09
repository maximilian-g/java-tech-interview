package com.maximilian.interview.array;

import java.util.Arrays;

/**
 * You are given an array of banknotes and target amount that you want to withdraw from ATM.
 * <p>
 * Task is to withdraw the amount using minimal possible quantity of banknotes
 * <p>
 * If withdrawal is impossible, return -1
 * You may use the same banknote as many times as possible.
 * Every banknote in input banknotes array is unique.
 */
public class MinBankNotes {

    public static int minBankNotes(int[] bankNotes, int targetAmount) {
        Arrays.sort(bankNotes);
        int usedBankNotes = 0;
        for (int i = bankNotes.length - 1; i >= 0; i--) {
            if (targetAmount >= bankNotes[i]) {
                usedBankNotes += targetAmount / bankNotes[i];
                targetAmount %= bankNotes[i];
            }
        }
        if (targetAmount > 0) {
            return -1;
        }
        return usedBankNotes;
    }

}
