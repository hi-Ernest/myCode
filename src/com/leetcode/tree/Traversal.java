package com.leetcode.tree;


import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Traversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else if (!stack.empty()) {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            } else {
                break;
            }
        }
        return list;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        //返回数值
        List<List<Integer>> lists = new ArrayList<>();

        //如何根节点是空
        if (root == null) {
            return lists;
        }

        //定义层次遍历的数据结构
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int levels = 0;

        while (!queue.isEmpty()) {

            lists.add(new ArrayList<>());

            int levels_length = queue.size();

            for (int i=0; i<levels_length; i++) {
                TreeNode t = queue.remove();

                lists.get(levels).add(t.val);

                if (t.left != null) {
                    queue.add(t.left);
                }

                if (t.right != null) {
                    queue.add(t.right);
                }

            }

            levels++;
        }
        return lists;

    }


}