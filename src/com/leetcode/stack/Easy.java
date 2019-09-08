package com.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.lang.Exception;

public class Easy {

    public static void main(String[] args) {
//        int i = 3;
//        while (i-->0) {
//            System.out.println("chr");
//        }


        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);

        System.out.println(stack);

        stack.pop();
        System.out.println(stack);
    }

    /**
     * 简单的括号判断
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        Map<Character, Character> map = new HashMap<>();

        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (int i=0; i<s.length(); i++) {
            if (stack.size() == 0) {
                stack.push(s.charAt(i));
                continue;
            }

            char ch = stack.peek();
            if (map.containsKey(ch) && map.get(ch) == s.charAt(i)) {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }

        if (stack.empty())
            return true;
        else
            return false;
    }
}