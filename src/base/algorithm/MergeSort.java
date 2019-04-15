package base.algorithm;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {8, 3, 2, 9, 7, 1, 5, 4};

        mergeSort(array);

        System.out.println(Arrays.toString(array));
    }


    public static void mergeSort(int[] array) {

        int[] B = new int[array.length/2];
        int[] C = new int[array.length/2];

        int[] A = new int[array.length];

        if (array.length > 1) {
            System.arraycopy(array, 0, B, 0, array.length/2);
            System.arraycopy(array, array.length/2, C, 0, array.length/2);

            System.out.println(Arrays.toString(B));
            System.out.println(Arrays.toString(C));
        }

        mergeSort(B);
        mergeSort(C);
        merge(B, C, A);

    }

    public static void merge(int[] B, int[] C, int[] A) {
        int i=0, j=0, k=0;
        while (i<B.length && j<C.length) {
            if(B[i] <= C[j]) {
                A[k] = B[i];
                i++;
            }
            else {
                A[k] = C[j];
                j++;
            }
        }

        if(i==B.length) {
            System.arraycopy(C, j, A, k, C.length-j);
        }else {
            System.arraycopy(B, i, A, k, B.length-i);
        }
    }


}
