package base.algorithm;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int[] array = {89,45,68,90,29,34,17};
//        int[] sorts2 = insertionSort_2(array);

        insertionSort(array);

        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(sorts2));
    }

    public static void insertionSort(int[] array) {

        for(int i=0; i<array.length; i++) {
            int v = array[i];
            int j = i-1;
            while (j>=0 && array[j]>v) {
                array[j+1] = array[j];
                j--;
                array[j+1] = v;
            }
        }
    }
//
//    public static int[] insertionSort_2(int[] array) {
//
//        if( array == null || array.length<2) {
//            return array;
//        }
//
//        for(int i=1; i<array.length; i++) {
//            for(int j=i; j>0; j--) {
//                if(array[j] < array[j+1]) {
//                    int temp=array[j];
//                    array[j]=array[j-1];
//                    array[j-1]=temp;
//                }
//            }
//        }
//        return array;
//    }
}
