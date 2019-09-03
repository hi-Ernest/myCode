package com.leetcode.list;

public class Solution {

    class ListNode {
        int val;
        ListNode next;

        //非头结点
        ListNode(int x) {
            val = x;
            next = null;
        }


        //头结点构造
//        ListNode(ListNode x) {
//              this.next = x;
//        }
    }


    public static void main(String[] args) {

    }


    private void addNode(int date) {
        ListNode newNode = new ListNode(date);
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;

        while (l1 != l2) {
            l1 = (l1 == null) ? headA : l1.next;
            l2 = (l2 == null) ? headB : l2.next;
        }

        return l1;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }

        return pre.next;
    }


    /**
     * 迭代：假定l1元素l2少,将l2中元素逐一插入l1中正确位置
     * 算法：设定一个哨兵节点(prehead),这样比较容易返回合并后的链表
     *      维护一个指针(prev),需要调整它的指针不断重复(l1.val 与 l2.val比较
     *      小的接在prev节点后面,小的指针向后移动一位)
     *      直到l1或l2指向null
     *      循环结束,至多一个非空,简单直接将非空链表接在合并链表后面
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            }else {
                prev.next  = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;


        return prehead.next;
    }


    /**
     * 递归
     *
     * 我们直接将以上递归过程建模，首先考虑边界情况。
     * 特殊的，如果 l1 或者 l2 一开始就是 null
     * 那么没有任何操作需要合并，所以我们只需要返回非空链表。
     * 否则，我们要判断 l1 和 l2 哪一个的头元素更小，
     * 然后递归地决定下一个添加到结果里的值。
     * 如果两个链表都是空的，那么过程终止，所以递归过程最终一定会终止。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists_(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}
