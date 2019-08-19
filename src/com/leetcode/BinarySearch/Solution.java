package com.leetcode.BinarySearch;

/**
 * 二分查找问题
 */
public class Solution {

    public static void main(String[] args) {

    }


    /**
     * 基本常规的二分查找算法
     * 折半查找的时间复杂度：O(logN)
     * @param nums
     * @param key
     * @return
     */
    public int binarySearch(int[] nums, int key) {
        int l=0, h = nums.length-1;

        while (l <= h) {

            //这里就是为了避免l+h > int范围的数值
            int mid = l + (l+h)/2;
            if (nums[mid] == key) {
                return mid;
            }else if (nums[mid] > key) {
                h = mid-1;
            }else {
                l = mid+1;
            }
        }
        return -1;
    }


    /**
     * 求得某个数值的开方
     * 详情:一个数 x 的开方 sqrt 一定在 0 ~ x 之间，并且满足 sqrt == x / sqrt。可以利用二分查找在 0 ~ x 之间查找 sqrt。
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int l = 1, h = x;

        while (l < h) {
            int mid = l+(h-l)/2;
            int sqrt = x/mid;

            if (mid == sqrt) {
                return mid;
            }else if (mid > sqrt) {
                h = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return h;
    }

    /**
     * Input:
     * letters = ["c", "f", "j"]
     * target = "d"
     * Output: "f"
     *
     * Input:
     * letters = ["c", "f", "j"]
     * target = "k"
     * Output: "c"
     */
    public char nextGreatestLetter(char[] letters, char target) {

        int l = 0, h = letters.length -1;

        while (l < h) {
            int mid = l+(h-l)/2;
            if (letters[mid] <= target) {
                l = mid + 1;
            }else {
                h = mid - 1;
            }
        }
        return l < letters.length?letters[l]:letters[0];
    }

    /**
     * 找出第一个错误的版本
     * 详情：题目描述：给定一个元素 n 代表有 [1, 2, ..., n] 版本
     * 在第 x 位置开始出现错误版本，导致后面的版本都错误。
     * 可以调用 isBadVersion(int x) 知道某个版本是否错误
     * 要求找到第一个错误的版本。
     */
    public int firstBadVersion(int x) {
        int l = 1, h = x;

        while (l < h) {
            int mid = l+(h-l)/2;
            if (isBadVersion(mid)) {
                h = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }


    /**
     * 旋转数组：求数组中对小数值
     *
     * Input: [3,4,5,1,2],
     * Output: 1
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }


    /**
     * 查找区间
     *
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     *
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch_2(nums, target);
        int last = binarySearch_2(nums, target+1) -1;

        if (first == nums.length || nums[first]!=target) {
            return new int[]{-1, -1};
        }else {
            return new int[]{first, Math.max(first, last)};
        }
    }

    private int binarySearch_2(int[] nums, int target) {
        int l=0, h = nums.length;

        while (l < h) {
            int mid = l+(h-l)/2;
            if (nums[mid] >= target) {
                h = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }



}
