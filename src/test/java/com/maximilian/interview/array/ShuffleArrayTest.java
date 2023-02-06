package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ShuffleArrayTest {

    @Test
    void shuffle() {
        Assertions.assertDoesNotThrow(() -> ShuffleArray.shuffle(new int[] {5, 3, 8, 222, 66}));
        Assertions.assertDoesNotThrow(() -> ShuffleArray.shuffle(new int[] {5, 3}));
        Assertions.assertDoesNotThrow(() -> ShuffleArray.shuffle(new int[] {5}));
        Assertions.assertDoesNotThrow(() -> ShuffleArray.shuffle(new int[] {}));
        int[] array = {5, 3, 8, 7, 10, 23, 6, 55, 4};
        int[] arrayToCompare = array.clone();
        ShuffleArray.shuffle(array);
        boolean differs = false;
        for(int i = 0; i < array.length; i++) {
            if (array[i] != arrayToCompare[i]) {
                differs = true;
                break;
            }
        }
        System.out.println("Initial = " + Arrays.toString(arrayToCompare));
        System.out.println("Result = " + Arrays.toString(array));
        Assertions.assertTrue(differs, "Arrays must differ after shuffling");
    }

}