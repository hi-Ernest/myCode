package com.leetcode.dp;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] test = {1,2,5};
        int amount =11;

        CoinChange change = new CoinChange();

        System.out.println(change.coinChange(test, amount));


        int[] a = new int[8];

        for (int v = 0; v<8 ; v++) {
            a[v] = -2;
        }

        System.out.println(Arrays.toString(a));

    }

    public int coinChange(int[] coins, int amount) {

        if (amount == 0)
            return 0;

        int ans = Integer.MAX_VALUE;

        for (int coin : coins) {

            //金额不可达
            if (amount - coin < 0)
                continue;

            int subProb = coinChange(coins, amount - coin);

            //子问题无解
            if (subProb == -1)
                continue;

            ans = Math.min(ans, subProb + 1);
        }


        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


    public int coinChange_note(int[] coins, int amount) {

//        if (amount == 0)
//            return 0;

        int[] sav = new int[amount + 1];

        //初始化
        for (int v = 0; v<8 ; v++) {
            sav[v] = -2;
        }

        return helper(coins, amount, sav);
    }

    private int helper(int[] coins, int amount, int[] sav) {

        if (amount == 0)
            return 0;

        if (sav[amount] != -2)
            return sav[amount];

        int ans = Integer.MAX_VALUE;

        for (int coin : coins) {

            if (amount - coin < 0)
                continue;

            int subPorb = helper(coins, amount, sav);

            if (subPorb == -1)
                continue;

            ans = Math.min(ans, subPorb + 1);
        }
        //记录本轮的答案
        sav[amount] = (ans == Integer.MAX_VALUE) ? -1 : ans;

        return sav[amount];

    }
}