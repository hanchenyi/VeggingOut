package com.example.demo.tutorial;

public class DynamicProgrammingImpl {
    /* Dynamic Programming problem is mostly just a matter of taking a recursion algorithm and
    * finding the overlapping subproblems, which are repeated calls, then cache those results
    * for future recursive calls */

    // Time O(n) and Space O(n)
    public static int climbStairOptimized(int n) {
        if (n == 1)
        {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i ++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    // Time O(n) and Space O(1)
    public static int climbStairOptimizedFibo(int n) {
        if (n == 1) {
            return 1;
        }
        int num0 = 1, num1 = 1;
        int num2 = 0;
        for(int i = 2; i <= n; i ++) {
            num2 = num0 + num1;
            num0 = num1;
            num1 = num2;
        }
        return num2;
    }
}
