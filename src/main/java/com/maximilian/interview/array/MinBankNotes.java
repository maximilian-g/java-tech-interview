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
        return minBankNotesInternal(bankNotes, bankNotes.length - 1, targetAmount, 0);
    }

    private static int minBankNotesInternal(int[] bankNotes, int startBackwards, int targetAmount, int count) {
        if (targetAmount == 0) {
            return count;
        }
        if (startBackwards < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (; startBackwards >= 0; startBackwards--) {
            if (targetAmount >= bankNotes[startBackwards]) {
                int backtrackResult = minBankNotesInternal(bankNotes, startBackwards - 1,
                        targetAmount % bankNotes[startBackwards], targetAmount / bankNotes[startBackwards]);
                if (backtrackResult != -1) {
                    res = Math.min(backtrackResult + count, res);
                }
            }
        }
        return res != Integer.MAX_VALUE ? res : -1;
    }

}
