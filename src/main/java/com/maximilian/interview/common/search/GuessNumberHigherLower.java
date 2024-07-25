package com.maximilian.interview.common.search;

import java.util.Random;

/**
 * <a href="https://leetcode.com/problems/guess-number-higher-or-lower/description">Link to a task</a>
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I will tell you whether the number
 * I picked is higher or lower than your guess.
 * <p>
 * You call a pre-defined API int guess(int num), which returns three possible results:
 * <p>
 * -1: Your guess is higher than the number I picked (i.e. num > pick).
 * 1: Your guess is lower than the number I picked (i.e. num < pick).
 * 0: your guess is equal to the number I picked (i.e. num == pick).
 * Return the number that I picked.
 */
public class GuessNumberHigherLower {

    private final int number;

    public GuessNumberHigherLower(int number) {
        this.number = number;
    }

    public int guessNumber(int n) {
        Random random = new Random();
        int guess = random.nextInt((n == 1 ? n + 1 : n));
        int rangeMin = 1;
        int rangeMax = n;

        int guessResult;
        while ((guessResult = guess(guess)) != 0) {
            if (guessResult > 0) {
                rangeMin = guess + 1;
            } else {
                rangeMax = guess - 1;
            }
            guess = rangeMin + ((rangeMax - rangeMin) / 2);
        }
        return guess;
    }

    private int guess(int guess) {
        return Integer.compare(number, guess);
    }

}
