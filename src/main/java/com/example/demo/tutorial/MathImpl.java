package com.example.demo.tutorial;

public class MathImpl {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = 1;
        boolean[] notPrime = new boolean[n];
        for (int i = 3; i < n; i += 2) {
            if (!notPrime[i]) {
                count ++;
            }
            for (int j = 3; i * j < n; j += 2) {
                notPrime[i * j] = true;
            }
        }
        return count;
    }

    public boolean isPowerOfThree(int n) {
        return n == 0 || (Math.log10(n) / Math.log10(3) % 1 == 0);
    }

    // combination and permutation
}
