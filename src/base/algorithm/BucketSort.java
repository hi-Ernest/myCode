package base.algorithm;

import java.util.Random;

/**
 * 桶排序
 * 稳定的排序算法
 * 常见算法中最快的 But非常耗空间
 *
 * 优点：最快最简单的排序
 * 缺点：浪费空间
 *      若不是整数而是小数
 *
 */
public class BucketSort {


    public static void main(String[] args) {
        int a[] = new int[10];

        for (int i=0; i<a.length; i++) {
            Random rd = new Random();
            a[i] = rd.nextInt(10);
        }

//        int[] a = {5, 5, 3, 2, 8, 1, 2, 8};

        int[] result = bucketSort(a);

        for (int i=0; i<result.length; i++) {
            for (int j=0; j<result[i]; j++) {
                System.out.print(i+" ");
            }
        }
    }


    public static int[] bucketSort(int[] array) {

        //若输入的是n个0～1000之间的整数---->需要1001个桶
        int a[] = new int[10];

        for (int i=0; i<a.length; i++)
            a[i] = 0;

        for (int i=0; i< array.length; i++) {
            int key = array[i];
            a[key]++;
        }

        return a;
    }



    /// <summary>
    /// 桶排序
    /// 1),已知其区间,例如[1..10],学生的分数[0...100]等
    /// 2),如果有重复的数字,则需要 List<int>数组,这里举的例子没有重复的数字
    /// </summary>
    /// <param name="unsorted">待排数组</param>
    /// <param name="maxNumber">待排数组中的最大数,如果可以提供的话</param>
    /// <returns></returns>
    static int[] bucket_sort(int[] unsorted, int maxNumber)
    {
        int[] sorted = new int[maxNumber + 1];
        for (int i = 0; i < unsorted.length; i++) {
            sorted[unsorted[i]] = unsorted[i];
        }
        return sorted;
    }

//    public static void main(String[] args) {
//        {
//            int[] x = {99, 65, 24, 47, 50, 88, 33, 66, 67, 31, 18, 99};
//            int[] sorted = bucket_sort(x, 99);
//
//            for (int i = 0; i < sorted.length; i++) {
//                if (sorted[i] > 0)
//                    System.out.println(sorted[i]);
//            }
//            System.out.println();
//        }
//    }

}
