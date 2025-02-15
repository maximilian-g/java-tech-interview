package com.maximilian.interview.common;

public class CombinationsCount {

    // C(N, K) = N! / (K! - (N - K)!)
    public static long getCombinationsCount(int n, int k) {
        // Use the property C(N, K) = C(N, N-K) to minimize iterations
        if (k > n - k) {
            k = n - k;
        }
        // example:
        // n = 52, k = 2
        // result = 52 * 51 / 2 * 1 = 1326
        long result = 1;
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }

        return result;
    }

}
