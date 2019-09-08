package com.leetcode.stack;

import java.util.Stack;

public class Medium {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> indexStack = new Stack<>();

        for (int currentIndex =0; currentIndex < n; currentIndex++) {
            while (!indexStack.isEmpty() && temperatures[currentIndex] > temperatures[indexStack.peek()]) {
                int preIndex = indexStack.pop();
                result[preIndex] = currentIndex - preIndex;
            }
            indexStack.push(currentIndex);
        }

        return result;
    }
}