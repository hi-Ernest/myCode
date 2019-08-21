package base.algorithm.sort;


import java.util.Arrays;

/**
 * shell排序 平均速度O(n^(3/2)) 最坏情况速度O(n^2)
 *
 */
public class ShellSort {

    public static void main(String[] args) {
//        int[] array = {89, 45, 68, 90, 29, 34, 17};
        int[] array = {4, 1, 10, 8, 7, 12, 9, 2, 15};

        long startTime = System.nanoTime();
//        shellSort(array);
//                shellsort3(array,array.length);
        sort(array);
        long endTime = System.nanoTime();
        System.out.println(Arrays.toString(array));
        System.out.println("程序运行时间： "+(endTime - startTime) + "ns");

//        shellsort3(array,array.length);
//        System.out.println(Arrays.toString(array));

    }

    /**
     * 1.将n个元素的数组分成n/2个数字序列，第1个数据和第n/2+1个数据为一对...
     * 2.一次循环使每一个序列对排好顺序
     * 3.接着，变为n/4个序列，再次排序
     * 4.重复，当序列减少为最后一个便排序完成
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int gap, i, temp, j;
        for (gap = arr.length / 2; gap > 0; gap /= 2) {//逐次减半，即数据间距，为0结束
            for (i = gap; i < arr.length; i++) {
                temp = arr[i]; //arr[5]=5
                j = i - gap;   //j= 0
                while (j >= 0 && temp < arr[j]) {      //5<arr[0]564
                    arr[j + gap] = arr[j];            //arr[5] = arr[0]
                    j -= gap;                        //-5
                }
                arr[j + gap] = temp;                //arr[0] = arr[5]
            }
        }
    }




    public static void shellsort3(int a[], int n) {
        int i, j, gap;

        for (gap = n / 2; gap > 0; gap /= 2) {
            for (i = gap; i < n; i++) {
                for (j = i - gap; j >= 0 && a[j] > a[j + gap]; j -= gap) {
                    int temp = a[j];
                    a[j] = a[j + gap];
                    a[j] = temp;
                }
            }
        }
    }


    public static void sort(int[] arr) {

        //增量gap 逐渐减小
        for (int gap = arr.length/2; gap>0; gap/=2) {

            for (int i=gap; i<arr.length; i++) {

                int j = gap;
                while (j-gap >=0 && arr[j] > arr[j-gap]) {
                    swap(arr, j, j-gap);
                    j-=gap;
                }
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];

    }


    public static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }
}