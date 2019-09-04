package xiecheng;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
//    static ListNode partition(ListNode head,int m) {
//        ListNode prehead = new ListNode(-1);
//        ListNode prev = prehead;
//
//        ListNode prehead1 = new ListNode(-1);
//        ListNode prev1 = prehead1;
//
//        while (head != null) {
//            if (head.val <= m) {
//                prev.next = head;
//                prev = prev.next;
//            }else {
//                prev1.next = head;
//                prev1 = prev1.next;
//            }
//            head = head.next;
//        }
//
//        prev.next = prehead1.next;
//
//        return prehead.next;
//
//    }
    /******************************结束写代码******************************/



    static ListNode partition(ListNode head,int m) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;

        while (head != null) {
            if (head.val <= m) {
                prev.next = head;
                prev = prev.next;

                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }

        prev.next = head;

        return prehead.next;

    }


//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        ListNode head=null;
//        ListNode node=null;
//        int m=in.nextInt();
//        while(in.hasNextInt()){
//            int v=in.nextInt();
//            if(head==null){
//                node=new ListNode(v);
//                head=node;
//            }else{
//                node.next=new ListNode(v);
//                node=node.next;
//            }
//        }
//        head= partition(head,m);
//        if(head!=null){
//            System.out.print(head.val);
//            head=head.next;
//            while(head!=null){
//                System.out.print(",");
//                System.out.print(head.val);
//                head=head.next;
//            }
//        }
//        System.out.println();
//    }




    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int schedule(int m,int[] array) {
        List<Integer> list = new ArrayList<>();

        int max = array[0];
        int len = array.length;
        for (int i=1; i<len; i++) {
            list.add(array[i] + array[i-1]);
            if (max < array[i]) {
                max = array[i];
            }
        }

        int[] result = new int[list.size()];
        for (int i=0; i<result.length; i++) {
            result[i] = list.get(i);
        }

        Arrays.sort(result);


        int end = 0;
        for (int i : result) {
            if (i >= max) {
                 end = i;
                 break;
            }
        }

        return end;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m,array);
        System.out.println(String.valueOf(res));
    }





    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {

//        char[] chars = expr.toCharArray();
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();

        map.put('(', '(');
        map.put(')', ')');

        for (int i=0; i<expr.length(); i++) {
            if (expr.charAt(i) == '(') {
                stack.push(expr.charAt(i));
            }
        }

        int index = 0;
        while (index < expr.length()) {
            char temp = expr.charAt(index);
//            if ( temp == '(' || temp == ) {
//                stack.push(temp);
//            }else if ()
        }


    }
    /******************************结束写代码******************************/
}
