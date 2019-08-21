package base.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    public static void main(String[] args) {

        int[] array = {89,45,68,90,29,34,17};
//        int[] sorts2 = insertionSort_2(array);

//        insertionSort(array);
//        insertionSort_2(array);
//        System.out.println(Arrays.toString(array));


        int a[] = new int[10];

        for (int i=0; i<a.length; i++) {
            Random rd = new Random();
            a[i] = rd.nextInt(10);
        }

//        System.out.println("Random Array: ");
//        System.out.println(Arrays.toString(a)+"\n");
//        System.out.println("Binary Insertion Sort: ");
        BinaryInsertion(array);
        System.out.println(Arrays.toString(array));
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


    /**
     * 二分插入排序，改进插入直接插入排序 
     * 在新元素插入到已序数组时，用二分法查找插入的位置
     * 最好情况：每次插入的位置k都是已序数组的最后的位置，则无需再执行移位赋值操作 O(n*log2n) 
     * 最坏情况：每次插入的位置k都是已序数组的最前的位置，则整个已序数组需要移位赋值 O(n^2)
     * 空间复杂度 O(1) * 稳定性 稳定 
     * 二分查找时间复杂度 O(log2n)
     */
    public static int[] BinaryInsertion(int[] a) {


        for (int i=1; i<a.length; i++) {

            int k = findByBinary(a, i);

            int key = a[i];

            for (int j=i-1; j>= k; j--) {
                a[j+1] = a[j];
            }
            a[k] = key;
        }

        return a;
    }

    private static int findByBinary(int[] a, int i) {

        int highIndex = i-1;
        int lowIndex = 0;
        int mid = -1;

        while (lowIndex <= highIndex) {

            mid = (lowIndex + highIndex)/2;

            if (a[i] >= a[mid]) {
                lowIndex = mid +1;
            }else {
                highIndex = mid -1;
            }
        }
        return lowIndex;
    }
}
