package com.leetcode.medium;

/**
 * @author Ernest Chen
 * @date 2020/6/4.
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //找到非排序的子序列-分割点
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        //即存在该分割点
        if (i >= 0) {
            //从后往前找到较小数值 与 分割点交换
            int j = nums.length - 1;
            //得到nums[j] > nums[i]
            while (j > 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(i, j, nums);
        }
        reverse(nums, i + 1);
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(start, end, nums);
            start++;
            end--;
        }
    }

}
