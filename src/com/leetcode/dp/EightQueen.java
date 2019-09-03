package com.leetcode.dp;

public class EightQueen {
    private static int num = 1; // 方案的总数
    private static final int MAX_QUEEN = 8;
    private static int[] position = new int[MAX_QUEEN];

    public static void main(String[] args) {
        trail(0);
    }
    /**
     * @Date: 2017/10/18
     * @Time: 下午5:00
     * @Method: isValid
     * @Return: 位置是否满足条件
     * @Description: 判断位置是否满足条件
     */

    static boolean isValid(int row) {
        for (int i = 0; i < row; i++) {
            /**
             * 如果前面放好的位置不在同一行、同一列、同一对角线
             * 则返回true
             * 否则返回false
             */
            if (position[i] == position[row] ||
                    Math.abs(position[i] - position[row]) ==
                            Math.abs(i - row) ) {
                return false;
            }
        }
        return true;
    }

    /**
     * @Date: 2017/10/18
     * @Time: 下午5:29
     * @Method: print
     * @Description: 打印皇后摆放位置的结果
     */
    static void print() {
        System.out.println("第" + num++ +"种摆法：");
        for (int i = 0; i < MAX_QUEEN; i++) {
            for (int j = 0; j < MAX_QUEEN; j++) {
                if(position[i] == j)
                    System.out.print("+ ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void trail(int row) {
        // 如果摆完MAX_QUEEN行，则输出结果
        if (row == MAX_QUEEN) {
            print();
            return;
        }
        for (int column = 0; column < MAX_QUEEN; column++) {
            position[row] = column; // 放在第row行第column列
            // 如果满足条件，则进行下一行
            if (isValid(row))
                trail(row + 1);
        }
    }
}

