package base.algorithm;

import java.util.Arrays;

/**
 * --------(蛮力法)
 * 选择排序
 * for n <- 0 to n-2 do
 *     min <- i
 *     for j <- i+1 to n-1 do
 *         if A[j] < A[min]
 *            min <- j
 *     swap A[i] and A[min]
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {89,45,68,90,29,34,17};
        selectionSort(array);
//        System.out.println(Arrays.toString(array));
    }

    public static void selectionSort(int[] array) {

        for(int i=0; i<array.length-1; i++) {
            int min = i;
            for(int j=i+1; j<array.length; j++) {
                if(array[j] < array[min]) {
                    min = j;
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if(i != min){  //交换a[i]和a[k]
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
            System.out.println(Arrays.toString(array));
        }
    }
}
