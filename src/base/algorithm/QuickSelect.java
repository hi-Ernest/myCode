package base.algorithm;

import base.algorithm.sort.ShellSort;

public class QuickSelect {

    public static void main(String[] args) {
        int[] array = {4, 1, 10, 8, 7, 12, 9, 2, 15};
//        LomutoPartition(array);
//        System.out.println(LomutoPartition(array));

//        QuickSelect(array, 0, array.length-1, 3);
        System.out.println(QuickSelect(array, 0, array.length-1, 4));
    }


    public static int LomutoPartition(int[] array) {

        int p = array[0];
        int s = 0;

        for(int i=0+1; i<array.length; i++) {
            if(array[i] < p) {
                s++;
                int temp = array[s];
                array[s] = array[i];
                array[i] = temp;
            }
        }
        ShellSort.swap(array[0],array[s]);
        return s;
    }

    public static int QuickSelect(int[] array, int low, int hight, int k) {

        int s= LomutoPartition(array);
        if(s == low+k-1) {
            return array[s];
        }
        else if(s > low+k-1) {
            return QuickSelect(array, low, s-1, k);
        }
        else
            return QuickSelect(array, s+1, hight, k);
    }

}
