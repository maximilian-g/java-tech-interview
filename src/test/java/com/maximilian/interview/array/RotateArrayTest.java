package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateArrayTest {

    @Test
    void rotate() {

        int[] val = new int[] {1,2,3,4,5,6,7};
        RotateArray.rotate(val, 3);
        Assertions.assertArrayEquals(new int[] {5,6,7,1,2,3,4}, val);

        val = new int[] {-1,-100,3,99};
        RotateArray.rotate(val, 2);
        Assertions.assertArrayEquals(new int[] {3,99,-1,-100}, val);

    }
}