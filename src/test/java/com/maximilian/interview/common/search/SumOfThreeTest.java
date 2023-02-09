package com.maximilian.interview.common.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SumOfThreeTest {

    @Test
    void getIndexesOfNSum() {

        int[] a = new int[]{5, 10, 100};
        int[] b = new int[]{100, 5, 10};
        int[] c = new int[]{5, 10, 100};
        int n = 30;
        int[] tmp = SumOfThree.getIndexesOfNSum(a, b, c, n);
        Assertions.assertEquals(n, a[tmp[0]] + b[tmp[1]] + c[tmp[2]]);


        a = new int[]{5, 10, 100};
        b = new int[]{5, 10, 100};
        c = new int[]{5, 10, 100};
        n = 15;
        tmp = SumOfThree.getIndexesOfNSum(a, b, c, n);
        Assertions.assertEquals(n, a[tmp[0]] + b[tmp[1]] + c[tmp[2]]);


        a = new int[]{5, 10, 100};
        b = new int[]{5, 10, 100};
        c = new int[]{5, 10, 0};
        n = 205;
        tmp = SumOfThree.getIndexesOfNSum(a, b, c, n);
        Assertions.assertEquals(n, a[tmp[0]] + b[tmp[1]] + c[tmp[2]]);

        a = new int[]{5, 10, 100};
        b = new int[]{5, 10, 100};
        c = new int[]{5, 10, 0};
        n = 200;
        tmp = SumOfThree.getIndexesOfNSum(a, b, c, n);
        Assertions.assertEquals(n, a[tmp[0]] + b[tmp[1]] + c[tmp[2]]);

        n = 0;
        tmp = SumOfThree.getIndexesOfNSum(a, b, c, n);
        Assertions.assertEquals(0, tmp.length);

    }

}