package hot.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Ernest Chen
 * @date 2020/7/10.
 *
 * leetcode[739]
 */
public class DailyTemperatures {

    /**
     * 暴力解法
     * time:O(nm)
     * space:O(n)
     * @param T
     * @return
     */
    public int[] violenceToSolve(int[] T) {
        int len = T.length;
        if (T == null || len == 0) {
            return new int[]{};
        }
        int index = 0;
        int[] res1 = new int[len];
        for (int i = 0; i < len - 1; i++) {
            boolean flag = true;
            for (int j = i + 1; j < len; j++) {
                if (T[j] > T[i]) {
                    res1[index++] = j - i;
                    flag = false;
                    break;
                }
            }
            if(flag) {
                res1[index++] = 0;
            }
        }
        //Integer[] res1 = res.toArray(new Integer[res.size()]);
        return res1;
    }

    /**
     * 使用栈
     *
     * @param T
     * @return
     */
    public int[] solveByStack(int[] T) {
        int len = T.length;
        if (T == null || len == 0) {
            return new int[]{};
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && T[stack.peekLast()] < T[i]) {
                int temp = stack.removeLast();
                res[temp] = i - temp;
            }
            stack.addLast(i);
        }
        return res;
    }


}
