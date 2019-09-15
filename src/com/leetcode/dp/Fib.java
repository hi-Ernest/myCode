package com.leetcode.dp;

/**
 * 斐波拉契数
 *
 * 当n=0时，f(n) = 0
 *
 * 当n=1时，f(n) = 1
 *
 * 当n>1时，f(n) = f(n-1) + f(n-2)
 */
public class Fib {

    public static void main(String[] args) {
        Fib fib = new Fib();

        System.out.println(fib.fib(20));

        System.out.println(fib.fib_note(20));

        System.out.println(fib.fib_dp(20));

        System.out.println(fib.fib_dp_2(20));
    }

    /**
     * 暴力的递归算法
     *
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N <= 0)
            return 0;

        if (N == 1)
            return 1;

        return fib(N - 1) + fib(N - 2);
    }


    public int Fibonacci(int n) {
        if (n < 2 && n >= 0)
            return n;

        int pre = 1;
        int prepre = 0;
        int sum = 0;

        for (int i = 2; i <= n; ++i) {
            sum = pre + prepre;
            prepre = pre;
            pre = sum;
        }
        return sum;
    }

    /**
     * 带有备忘录的递归
     * 递归树 -> 减枝
     *
     * @param N
     * @return
     */
    public int fib_note(int N) {

        if (N < 1) {
            return 0;
        }

        //备忘录初始化为0
        int[] sav = new int[N+1];

        return helper(sav,  N);

    }

    private int helper(int[] sav, int n) {

        if (n == 1 || n == 2)
            return 1;

        if (sav[n] != 0)
            return sav[n];

        //未计算
        sav[n] = helper(sav, n-1) + helper(sav, n-2);
        return sav[n];
    }


    //DP table
    //Time:O(N)
    //Space:O(N)
    public int fib_dp(int N) {

        int[] dp = new int[N + 1];

        dp[1] = dp[2] = 1;

        for (int i = 3; i<=N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[N];
    }


    //将空间复杂度降到O(1)
    public int fib_dp_2(int N) {

        int pre = 0, curr = 1;

        if (N < 2)
            return N;

        //Index 从 0 -> 18
        for (int i = 0; i < N-1; i++) {
            int temp = pre + curr;
            pre = curr;
            curr = temp;
        }

        return curr;
    }





}
