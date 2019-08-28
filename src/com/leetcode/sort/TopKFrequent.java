package com.leetcode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {

    public static void main(String[] args) {

    }


    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyForNum = new HashMap<>();

        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0)+1);
        }

        //设置桶 一个桶中有一个List
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        //Map中key的集合
        for (int key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);

            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        List<Integer> topK = new ArrayList<>();

        for (int i = buckets.length-1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }

            if (buckets[i].size() <= (k - topK.size())) {
                topK.addAll(buckets[i]);
            }else {
                topK.addAll(buckets[i].subList(0, k-topK.size()));
            }
        }
        return topK;
    }
}
