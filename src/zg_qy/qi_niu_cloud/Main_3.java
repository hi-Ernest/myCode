package zg_qy.qi_niu_cloud;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_3 {

    static String s = "-1 -1";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        int[] array = new int[len];

        for (int i=0; i<len; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(array));

        int input = scanner.nextInt();

        Main_3 main = new Main_3();
        main.getResult(array, input);

    }


    public void getResult(int[] array, int input) {



        int start = 0;
        int end = array.length-1;

//        while (end > start) {
//            if (array[start] == input) {
//                System.out.println(start);
//            }
//
//            if (array[end] == input) {
//                System.out.println(end);
//            }
//            start++;
//            end--;
//        }
        if (array.length == 0) {
            System.out.println(s);
        }else {
            List<Integer> list = new ArrayList<>();
            while (start <= array.length-1) {
                if (array[start] == input) {
                    list.add(start);
                }
                start++;
            }

            if (list.size() == 0) {
                System.out.println(s);
            }else if (list.size() == 1) {
                System.out.print(list.get(0) +" "+list.get(0));
            }else {
                System.out.println(list.get(0)+" "+list.get(list.size()-1));
            }
        }

    }

}
