package com.leetcode.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthElement {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};

        System.out.println(new KthElement().findKthLargest_2(nums,2));


        System.out.println(new KthElement().findKthLargest_3(nums, 4));
    }


    /**
     * 算法时间复杂度：O(NlogN), 空间复杂度：O(1)
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        //排序
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


    /**
     * 优先队列 = 最小堆
     * 添加add -> offer = 优先级越高(最小)放在根节点位置
     * 删除poll -> 删除头部元素
     * peek -> 返回头部元素
     *
     *
     * 堆 = 二叉树(2i+1、2i+2)：时间：O(NlogK) 空间：O(K)
     */
    public int findKthLargest_2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //小顶堆
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }


    /**
     * 快速选择
     */
    public int findKthLargest_3(int[] nums, int k) {
        k = nums.length - k;

        int l=0, h = nums.length -1;
        while (l<h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            }else if (j < k) {
                l = j+1;
            }else {
                h = j-1;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int l, int h) {
        int i = l, j = h+1;

        while (true) {
            while (a[++i] < a[l] && i<h);
            while (a[--j] > a[l] && j>l);

            if (i >= j) {
                break;
            }

            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }




}
