package com.leetcode.Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HashPrblems {

    /**
     * 数组中两个数的和为给定值
     * 时间复杂度为 O(N)
     * 空间复杂度为 O(N)
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }else {
                map.put(nums[i], i);
            }
        }
        return null;
    }


    /**
     * 判断数组是否存在重复元素
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        return set.size() < nums.length;
    }



}
