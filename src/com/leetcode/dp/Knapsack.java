package com.leetcode.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack {

    /**
     * W：背包的体积
     * N：物品的数量
     * weights：数组存储N个物品的重量
     * values：数组存储N个物品的价值
     *
     * @param W
     * @param N
     * @param weights
     * @param values
     * @return
     */
    public int knapsack(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[W + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];

            for (int j = 1; j <= W; j++) {
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }

    public int knapsack_2(int W, int N, int[] weights, int[] values) {
        int[] dp = new int[W + 1];

        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];

            for (int j = W; j >= 1; j--) {
                if (j >= w) {
                    dp[j] = Math.max(dp[j], dp[j - w] + v);
                }
            }
        }
        return dp[W];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //4
        int number = scanner.nextInt();

        String read = scanner.nextLine();

        int w = scanner.nextInt();

        String read2 = scanner.nextLine();

        String[] input = scanner.nextLine().split(" ");
        int[] weghts = new int[number];
        int[] values = new int[number];

        for (int i = 0; i < number; i++) {
            weghts[i] = Integer.parseInt(input[i]);
        }

        input = scanner.nextLine().split(" ");

        for (int j = 0; j < number; j++) {
            values[j] = Integer.parseInt(input[j]);
        }

        System.out.println(number+" " + w +" "+Arrays.toString(weghts)+" "+Arrays.toString(values));

        Knapsack knapsack = new Knapsack();
        System.out.println( knapsack.knapsack(w,number, weghts, values));

    }
}
