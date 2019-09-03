package com.leetcode.dp;

public class Solution {

    //输出步数次数
    static int s = 1;
    public static int[] steps = new int[10];


    public static void main(String[] args) {

        Solution solution = new Solution();
        tryStep(4);

//        System.out.println(solution.climbStairs(4));
//        System.out.println(solution.climbStairs_dp(4));
    }

    //爬楼梯
    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        int pre2 = 1, pre1 = 2;
        for (int i = 2; i < n; i++) {
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }


    /**
     * 动态规划： 多个子问题 dp[n] = dp[n-1] + dp[n-2]
     * 初始化：dp[0] = dp[1] = 1
     * Time:O(n^2)
     *
     * @param n
     * @return
     */
    public int climbStairs_dp(int n) {

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i=2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }


    /**
     * 回溯法思想：
     *          1)搜索策略：符合递归,问题解决可以化成子问题,算法类似,规模减小
     *          2)控制策略：当遇到失败的搜索状态,需要返回上一状态,沿另外的路径搜索
     *          3)数据结构：一般用数组保存搜索过程中的状态或路径
     * @param n
     */
    static void tryStep(int n){ // 爬n级楼梯
        for (int i = 1; i <= 2; i++){
            // 对于每次爬有两次尝试，一次爬1级或者一次爬2级
            if (n < i)
                break;
            steps[s++] = i; // 一步走了i级台阶
            n -= i; //缩小问题的规模
            if (n == 0) {
                for (int j = 1; j < s; j++){
                    System.out.print("第"+ j + "步走了" + steps[j]
                            + "级台阶 ");
                }
                System.out.println();
            } else {
                tryStep(n);
            }
            n += i;
            steps[s--] = 0;
        }
    }
}
