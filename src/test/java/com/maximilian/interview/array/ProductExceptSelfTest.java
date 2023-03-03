package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductExceptSelfTest {

    @Test
    void productExceptSelf() {
        Assertions.assertArrayEquals(new int[] {24,12,8,6}, ProductExceptSelf.productExceptSelf(new int[] {1,2,3,4}));
        Assertions.assertArrayEquals(new int[] {0,0,9,0,0}, ProductExceptSelf.productExceptSelf(new int[] {-1,1,0,-3,3}));
        Assertions.assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0}, ProductExceptSelf.productExceptSelf(new int[] {-1,1,0,-3,3, 5, 7, 10, 0}));
    }

}