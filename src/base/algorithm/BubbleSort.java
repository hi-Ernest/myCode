package base.algorithm;

import java.util.Arrays;

/**
 * --------(蛮力法)
 * 冒泡排序
 *
 * for i <-0 to n-2 do
 *     for j <- 0 to n-2-i do
 *         if A[j+1] < A[j]
 *            swap A[j] and A[j+1]
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {89,45,68,90,29,34,17};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        for(int i=0; i<array.length-1; i++) {
            for(int j=0; j<array.length-1-i; j++) {
                if(array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
//                System.out.println(Arrays.toString(array));
            }
        }

    }
}
