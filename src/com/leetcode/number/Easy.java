package com.leetcode.number;

public class Easy {

    public static void main(String[] args) {
        char chr = 127;
        int sum = 200;

        chr += 1;

        System.out.println(Integer.valueOf(chr));

        sum += chr;

        System.out.println(sum);

        float []f[] = new float[6][6];

    }

    /**
     * 非递减数列
     *
     * 输入: [4,2,3]
     * 输出: True
     * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
     *
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (count == 1) return false;
                if ((i - 2 >= 0) && nums[i] < nums[i - 2]) {
                    nums[i] = nums[i - 1];
                }
                count++;
            }
        }
        return true;

    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n -1)) == 0;
    }
}
