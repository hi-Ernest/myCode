package com.leetcode.thread;

import java.util.Arrays;

public class Funtion {
    static int[] arr = {1,3,4,5,6,7,8,9};

    public static void main(String[] args) {
        //返回一个流对象,对象的集合
        Arrays.stream(arr).forEach((x) -> {
            System.out.println(x);
        });

        System.out.println();

        //方法引用
        Arrays.stream(arr).forEach(System.out::println);

        Double a = 1.1;
        short b = 1;
    }


}
