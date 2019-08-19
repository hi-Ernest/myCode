package base.algorithm;

import java.util.Arrays;
import java.util.Random;

public class QuickSort_247 {

    public static void main(String[] args) {

        int[] a = new int[20];


        for (int i=0; i<a.length; i++) {
            Random random = new Random();
            a[i] = random.nextInt(100);
        }

        sort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] arr, int left, int right) {

        if (left < right) {
            int index = partition(arr, left, right);
            sort(arr, left, index-1);
            sort(arr, index+1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {

        int p = arr[left];
        int i = left + 1;
        int j = right;

        while (i < j) {

            while (arr[j] > p) {
                j--;
            }

            while (arr[i] < p) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, j);
        swap(arr, j, left);
        return j;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }


}
