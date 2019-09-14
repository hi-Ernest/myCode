package zg_qy.xiao_mi;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * 给定一个数列，每一次移动可以将数列某个数移动到某个位置上，
 * 移动多次后，形成新的数列。
 * 定义数列中相邻两两之间的差的绝对值为“移动距离”，
 * 定义所有移动距离的总和为“总移动距离”。希望计算出最少的移动次数，使得新数列的“总移动距离”最小。
 * 例如原数列为[4,2,7,6]，总移动距离为2+5+1=8。将6移动到7之前，会变成[4,2,6,7]，总移动距离变成2+4+1=7。
 *
 * 需要编写一个函数，输入为一个int数组表示数列内容，输出为一个int数字，表示最小移动次数
 *
 * 第一行输入为数组大小，然后依次输入数组元素，如数组[4, 2, 7, 6]
 * 总移动距离最小的数列之一为[2,4,6,7]
 *
 * 最少移动次数：2
 *
 *
 *
 *
 */
public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int solution(int[] arr) {

        int len = arr.length;
        int[] oldArr = Arrays.copyOf(arr,len);

        int min = Integer.MAX_VALUE;
        int saveIndex = 0;
        for (int i=0; i<len-1; i++) {
            for (int j=i+1; j<len; j++) {

                int temp = Math.abs(arr[i] - arr[j]);

                if (temp < min) {
                    min = temp;
                    saveIndex = j;
                }
            }
            if (saveIndex != i+1) {
                int temp = arr[i+1];
                arr[i+1] = arr[saveIndex];
                arr[saveIndex] = temp;
            }
            min = Integer.MAX_VALUE;
        }

        int first = Math.abs(arr[0] - arr[2]);
        int second = Math.abs(arr[1] - arr[2]);
        if (first < second) {
            int temp = arr[1];
            arr[1] = arr[0];
            arr[0] = temp;
        }


        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(oldArr));

        int moveCount = 0;
        for (int i=0; i<len; i++) {
            if (oldArr[i] != arr[i]) {
                moveCount++;
            }
        }

        return moveCount/2;
    }




    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }

        res = solution(_arr);
        System.out.println(String.valueOf(res));

    }
}
