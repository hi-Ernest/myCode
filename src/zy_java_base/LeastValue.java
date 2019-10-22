package zy_java_base;

import java.util.ArrayList;
import java.util.Scanner;

public class LeastValue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int count = sc.nextInt();
        int[] value = new int[count];

        for(int i = 0; i < count; i++){
           value[i] = sc.nextInt();
        }

        System.out.println(getLeastValue(money, value));
    }

    //先将输入的硬币面值排序大到小
    //先处于小的 / %
    //将数量相加
    public static int getLeastValue(int money, int[] value) {
        ArrayList<Integer> list = new ArrayList<>();

        new LeastValue().sort(value, 0, value.length-1);


        int count =0;
        for(int i=0; i<value.length; i++) {
            count += money/value[i];
            value[i+1] = money%value[i];
            money -=value[i]*(money/value[i]);
        }

        int resule = -1;
        if(resule != -1)
            return value[resule-1];
        else
            return resule;
    }

    public void sort(int array[], int left, int right) {
        if (left <right) {
            int index = partition(array, left, right);
            sort(array, left, index-1);
            sort(array, index, right);
        }

    }

    public int partition(int[] array, int left, int right) {
        if(array==null || array.length<=0 || left<0 || right>=array.length){
            return 0;
        }
        int prio = array[left + (right - left) / 2];
        while(left<=right){
            while (array[left] < prio)
                left++;
            while (array[right] > prio)
                right--;
            if (left<=right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
