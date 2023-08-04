package com.maximilian.interview.common.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumProductSubarrayTest {

    @Test
    void maxProduct() {

        Assertions.assertEquals(6, MaximumProductSubarray.maxProduct(new int[]{2, 3, -2, 4}));
        Assertions.assertEquals(0, MaximumProductSubarray.maxProduct(new int[]{-2, 0, -1}));

    }

}