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
             l1 = (l1 == null)?headA:l1.next;
             l2 = (l2 == null)?headB:l2.next;
         }

         return l1;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode pre = new ListNode(0);
         ListNode cur = pre;
         int carry = 0;

         while (l1 != null || l2 != null) {
             int x = l1 == null? 0 : l1.val;
             int y = l2 == null? 0 : l2.val;

             int sum = x + y +carry;

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


}
