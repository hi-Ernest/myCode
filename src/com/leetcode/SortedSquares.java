package com.leetcode;

import java.util.Arrays;

public class SortedSquares {

    public static void main(String[] args) {
        int[] test = {-4,-1,0,3,10};

        System.out.println(Arrays.toString( new SortedSquares().sortedSquares(test)));
    }

    public int[] sortedSquares(int[] A) {

        int[] B = new int[A.length];

        for(int i=0; i<A.length; i++) {
            B[i] = A[i]*=A[i];
        }

        insertionSort(B);
        return B;
    }

//    private void swap(int n, int m, int[] arr) {
//        int temp = arr[n];
//        arr[n] = arr[m];
//        arr[m] = temp;
//    }

    private void insertionSort(int[] arr) {
        for(int i=1; i<arr.length; i++) {
            int max = arr[i];
            int j = i-1;
            while(j>=0 && arr[j] > max) {
                arr[j+1] = arr[j];
                j--;
                arr[j+1] = max;
            }
        }
    }

}
