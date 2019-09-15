package com.leetcode.dp;

public class CoinChange {

    public static void main(String[] args) {
        int[] test = {1,2,5};
        int amount =11;

        CoinChange change = new CoinChange();

        System.out.println(change.coinChange(test, amount));
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


        return ans == In0teger.MAX_VALUE ? -1 : ans;
    }


//    public int coinChange_note(int[] coins, int amount) {

//        if (amount == 0)
//            return 0;
//
//        int[] sav = new int[coins.length];





//    }
}