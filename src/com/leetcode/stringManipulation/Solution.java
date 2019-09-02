package com.leetcode.stringManipulation;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        String s = "abcabcbb";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }

    //无重复字符的最长字串
    //滑动窗口
    public int lengthOfLongestSubstring(String s) {

        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int start = 0, end = 0; end < n; end++) {

            Character c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }

            ans = Math.max(end - start + 1, ans);
            map.put(c, end + 1);
        }

        return ans;
    }


    /**
     * 寻找两个有序数组的中位数
     *
     * 总体思路：合并数组 -----> 分成偶数/奇数 ----> 找出中位数
     *
     * Time：O(m+n)
     * Spece：O(m+n)
     *
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] nums;
        int m = nums1.length, n = nums2.length;
        nums = new int[m+n];

        //可能两个数组其中一个为空
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n/2-1] + nums2[n/2])/2.0;
            }else
                return nums2[n/2];
        }

        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m/2-1] + nums1[m/2])/2.0;
            }else
                return nums1[m/2];
        }


        //两个数组都不为空
        int count = 0 , i = 0, j =0;
        while (count != (m + n)) {

            //当其中一个数组已经填完了 ----> 另一个数组剩余的全部元素 --> 全部填入
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }

            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }


            //比较数组 ---> 较小元素先行填充
            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            }else {
                nums[count++] = nums2[j++];
            }
        }


        if (count % 2 == 0) {
            return (nums[count / 2] + nums[count / 2 -1])/2.0;
        }else {
            return nums[count/2];
        }
    }
}