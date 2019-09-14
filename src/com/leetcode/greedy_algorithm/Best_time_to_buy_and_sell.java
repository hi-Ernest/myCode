package com.leetcode.greedy_algorithm;

/**
 *
 *
 *
 *
 *
 */
public class Best_time_to_buy_and_sell {

    /**
     * 只能交易一次
     * @param prices
     * @return
     */
    public int maxProfit_1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = max(dp[i-1][1], -prices[i])
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }


    public int maxProfit_1_1(int[] prices) {
        int n = prices.length;
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i=0; i<n; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }else if (prices[i] - min > max){
                max = prices[i] - min;
            }
        }

        if (max < 0) return 0;
        return max;
    }

    /**
     * 不限制交易次数
     * @param prices
     * @return
     */
    public int maxProfit_2(int[] prices) {
        int length = prices.length;

        if (length == 0|| length == 1) {
            return 0;
        }

        int profit = 0;
        int min = prices[0];

        for (int i =1; i<length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }else if (prices[i] > min) {
                profit += prices[i] - min;
                min = prices[i];
            }
        }
        return profit;
    }

    public int maxProfit_2_2(int[] prices) {
        int n = prices.length;

        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            int temp =dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }

        return dp_i_0;
    }

    /**
     * k = 2
     * 限制两次交易
     * @param prices
     * @return
     */
    public int maxProfit_3(int[] prices) {
        int n = prices.length;
        int maxK = 2;

        int[][][] dp = new int[n][maxK+1][2];

        for (int i=0; i<n; i++) {
            for (int k = maxK; k>=1; k--) {
                /* base case */
                if (i-1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        return dp[n-1][maxK][0];
    }




    int maxProfit_k_any(int max_k, int[] prices) {
        int n = prices.length;
//        if (max_k > n / 2)
//            return maxProfit_k_inf(prices);

        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++)
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    /* 处理 base case */
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        return dp[n - 1][max_k][0];
    }

}
