package com.leetcode;

public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return setTreeNode(nums, 0, nums.length-1);
    }

    public TreeNode setTreeNode(int[] nums, int lo, int hi) {
        if(lo == hi)
            return new TreeNode(nums[lo]);
        else if(lo < hi)
            return null;

        int index = getMaxIndex(nums,lo,hi);
        TreeNode root = new TreeNode(nums[index]);
        root.left = setTreeNode(nums, lo, index-1);
        root.right = setTreeNode(nums, index, lo);

        return root;
    }

    public int getMaxIndex(int[] nums, int lo, int hi) {
        if(lo == hi)
            return lo;

        int index = lo;
        int maxValue = nums[lo];
        for(int i=lo; i<=hi; i++) {
            if(nums[i] > maxValue) {
                maxValue = nums[i];
                index = i;
            }
        }
        return index;
    }

     class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) {
             val = x;
         }
     }

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        System.out.println( new ConstructMaximumBinaryTree().constructMaximumBinaryTree(nums));
        new ConstructMaximumBinaryTree().constructMaximumBinaryTree(nums);
    }
}
