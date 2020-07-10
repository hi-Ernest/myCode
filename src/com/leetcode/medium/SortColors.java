package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ernest Chen
 * @date 2020/6/3.
 *
 * leetcode-75
 */
public class SortColors {

    public static void main(String[] args) {
        new SortColors().sortColors(new int[]{2,0,2,1,1,0});
    }


    public void sortColors(int[] nums) {
        int[] buckets = new int[3];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i]]++;
        }

        System.out.println("buckets " + Arrays.toString(buckets));

        //List<Integer> res = new ArrayList<>();
        int index = 0;
        for (int j = 0; j < buckets.length; j++) {
            for (int k = 0; k < buckets[j]; k++) {
                //res.add(j);
                nums[index++] = j;
            }
        }

        System.out.println(Arrays.toString(nums));

    }

}
