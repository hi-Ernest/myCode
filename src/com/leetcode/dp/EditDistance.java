package com.leetcode.dp;

/**
 * 考虑程序的鲁棒性
 */
public class EditDistance {


    /**
     * 将s1 -> s2 (转化的最少操作数)
     *
     * @param s1
     * @param s2
     * @return
     */
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if (m == 0) return n;
        if (n == 0) return m;

        //s1的前i个字符转化成s2的前j个字符需要最少多少步
        int[][] dp = new int[m+1][n+1];

        //base case
        for (int i=1; i<=m; i++) {
            dp[i][0] = i;
        }

        for (int j=1; j<=n; j++) {
            dp[0][j] = j;
        }

        //自底向上求解
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    //dp[i-1][j-1] + 1 -> 替换,   dp[i-1][j] + 1 -> 删除,   dp[i][j-1] + 1 -> 插入
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }

        return dp[m][n];
    }
}
