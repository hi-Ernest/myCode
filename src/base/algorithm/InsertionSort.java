package base.algorithm;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int[] array = {89,45,68,90,29,34,17};
//        int[] sorts2 = insertionSort_2(array);

//        insertionSort(array);
        insertionSort_2(array);

        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(sorts2));
    }

//    public static void insertionSort(int[] array) {
//
//        for(int i=0; i<array.length; i++) {
//
//            //取得最新的待插入的元素
//            int v = array[i];
//
//            //已经排序好的有序列表下标
//            int j = i-1;
//
//            //从后往前扫描
//            while (j>=0 && array[j]>v) {
//                array[j+1] = array[j];
//                j--;
//                array[j+1] = v;
//            }
//        }
//    }

    public static int[] insertionSort_2(int[] array) {

        if( array == null || array.length<2) {
            return array;
        }

        for(int i=1; i<array.length; i++) {
            int j = i;
            while (j>0 && array[j] < array[j-1]) {
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                j--;
            }
        }
        return array;
    }
}
