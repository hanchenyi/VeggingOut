package com.example.demo.tutorial;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MathImpl {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = 1;
        boolean[] notPrime = new boolean[n];
        for (int i = 3; i < n; i += 2) {
            if (!notPrime[i]) {
                count++;
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

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
            if (-n == Integer.MIN_VALUE) {
                return x * myPow(x, (n - 1));
            }
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    public void xor() {
        int[] states = new int[]{1, 0, 0, 1, 1, 1}; // [0, 1, 1, 1, 0, 1] [1, 1, 0, 1, 0, 0]
        int len = states.length;
        int days = 2;
        while (days > 0) {
            int[] cur = new int[len];
            for (int i = 0; i < len; i++) {
                int tmp = 0;
                if (i == 0) {
                    tmp = states[i + 1] ^ 0;
                } else if (i == len - 1) {
                    tmp = states[i - 1] ^ 0;
                } else {
                    tmp = states[i - 1] ^ states[i + 1];
                }
                cur[i] = tmp;
            }
            states = cur;
            days = days - 1;
        }
        System.out.println(Arrays.stream(states).boxed().collect(Collectors.toList()));
    }
}
