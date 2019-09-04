package com.leetcode.stack;

import java.util.Stack;
import java.lang.Exception;

public class Easy {

    public static void main(String[] args) {

    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        char[] chars1 = {'{','}','(',')','[',']'};

        for (int i=0; i<chars.length; i++) {
            stack.push(chars[i]);
            while (!stack.isEmpty()) {
//                stack.push()
            }
        }

        return true;
    }
}