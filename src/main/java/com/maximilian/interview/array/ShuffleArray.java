package com.maximilian.interview.array;

import java.util.Random;

/**
 * Mix array
 */
public class ShuffleArray {

    public static void shuffle(int[] array) {
        Random random = new Random();
        for (int j = 0; j < array.length / 2; j++) {
            int randomIndex = random.nextInt(j + 1, array.length);
            int tmp = array[randomIndex];
            array[randomIndex] = array[j];
            array[j] = tmp;
        }
    }

}
