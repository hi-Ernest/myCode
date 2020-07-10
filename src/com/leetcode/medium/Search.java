package com.leetcode.medium;

/**
 * @author Ernest Chen
 * @date 2020/6/4.
 *
 * leetcode 33
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 */
public class Search {

    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            //真值表-判断是两项为真 还是 一项为真
            //两项为真时异或结果为假，一项为真时异或结果为真
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])) {
                lo = mid + 1;
            }else {
                hi = mid;
            }
        }
        return lo == hi && nums[lo] == target ? lo : -1;

//        int left = 0, right = nums.size() - 1;
//        int mid = 0;
//
//        while (left < right){
//            mid = (left + right) / 2;
//
//            if (nums[left] <= nums[mid] && target <= nums[mid] && nums[left] <= target)      // 右边界左移  第一种情况
//                right = mid;
//            else if (nums[left] > nums[mid] && (target >= nums[left] || target <= nums[mid]))      // 右边界左移  第二种情况
//                right = mid;
//            else                                   // 其余情况左边界右移
//                left = mid + 1;
//        }
//        return left == right && nums[left]==target? left : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Search().search(new int[]{5,6,7,0,1,2}, 0));
    }
}
