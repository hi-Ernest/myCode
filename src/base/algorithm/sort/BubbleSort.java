package base.algorithm.sort;

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
        int[] a = {5, 1, 4, 2, 8};
//        int[] array = {89,45,68,90,29,34,17};
//        bubbleSort(a);

        bubbleSort_2(a);
    }

    public static void bubbleSort(int[] array) {

        //外层循环：每次循环就确定一个相对最大的元素
        for(int i=0; i<array.length-1; i++) {
            //内层循环：有i个元素排好，根据i确定本次的比较次数
            for(int j=0; j<array.length-1-i; j++) {
                //判断前一位是否大于后一位
                if(array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }

            System.out.print("第"+(i+1)+"轮排序结果： ");
            System.out.print(Arrays.toString(array)+ "\n");
        }
    }


    /**
     * 改进: 若发现一次外层循环没有发生swap,则已经完成排序,立即结束
     * @param array
     */
    public static void bubbleSort_2(int[] array) {

        //外层循环：每次循环就确定一个相对最大的元素
        for(int i=0; i<array.length-1; i++) {

            boolean exchange = false;

            //内层循环：有i个元素排好，根据i确定本次的比较次数
            for(int j=0; j<array.length-1-i; j++) {
                //判断前一位是否大于后一位
                if(array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;

                    if (!exchange) exchange = true;
                }
            }

            System.out.print("第"+(i+1)+"轮排序结果： ");
            System.out.print(Arrays.toString(array)+ "\n");

            if (!exchange) break;
        }
    }




    /**
     * 针对有些前面或者后面已经有序了
     * 使用一个指针如pos pos后面的数据在上一轮排序中没有发生交换，下一轮排序对POS之后的数据不再比较
     */


    /**
     *
     *
     void cocktail_sort(int arr[], int len) {
     int j, left = 0, right = len - 1;
     while (left < right) {
     for (j = left; j < right; j++)
     if (arr[j] > arr[j + 1])
     swap(arr[j], arr[j + 1]);
     right--;
     for (j = right; j > left; j--)
     if (arr[j - 1] > arr[j])
     swap(arr[j - 1], arr[j]);
     left++;
     }

     */







}
