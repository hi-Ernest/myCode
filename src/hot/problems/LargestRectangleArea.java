package hot.problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Ernest Chen
 * @date 2020/7/4.
 */
public class LargestRectangleArea {

    /**
     * 固定高，求最长的底边
     * 遍历数组-比较
     * time：O(n^2)
     * space: O(1)
     */
    public static int violenceToSolve(int[] heights) {
        if (heights == null || heights.length <= 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int i = 0;
        while (i != heights.length) {
            int index = 1;
            int j = i - 1;
            int k = i + 1;
            while (j >= 0 && heights[j] >= heights[i]) {
                index++;
                j--;
            }
            while (k <= heights.length - 1 && heights[k] >= heights[i]) {
                index++;
                k++;
            }
            max = max < heights[i] * index ? heights[i] * index : max;
            i++;
        }
        return max;
    }


    /**
     * 使用栈-单调栈
     * time:O(N)
     * space:O(N)
     */
    public static int monotonousStackToSolve(int[] heights) {
        int len = heights.length;
        if (heights == null || len == 0) {
            return 0;
        }
        int area = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                int height = heights[stack.removeLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                    stack.removeLast();
                }
                int width;
                if (stack.isEmpty()) {
                    width = i;
                }else {
                    width = i - stack.peekLast() - 1;
                }
                area = Math.max(area, width * height);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int height = heights[stack.removeLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                stack.removeLast();
            }
            int width;
            if (stack.isEmpty()) {
                width = len;
            }else {
                width = len - stack.peekLast() - 1;
            }
            area = Math.max(area, width * height);
        }
        return area;
    }

    /**
     * 在栈的基础上使用哨兵
     * @param heights
     * @return
     */
    public static int sentilnelOfStackToSolve(int[] heights) {
        int len = heights.length;
        if (heights == null || len == 0) {
            return 0;
        }

        int[] newHeights = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newHeights[i + 1] = heights[i];
        }
        len += 2;
        heights = newHeights;

        int area = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);

        for (int i = 1; i < len; i++) {
            while (heights[stack.peekLast()] > heights[i]) {
                int height = heights[stack.removeLast()];
                int width = i - stack.peekLast() - 1;
                area = Math.max(area, width * height);
            }
            stack.addLast(i);
        }
        return area;
    }

    public static void main(String[] args) {
        int[] array = new int[] {2,1,5,6,2,3};
//        int[] array = new int[] {2, 0, 2};
//        int[] array = new int[] {2,1,0, 2};
        System.out.println(monotonousStackToSolve(array));


    }
}
