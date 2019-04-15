package com.leetcode;



public class ToLowerCase {

    public static void main(String[] args) {

        System.out.println(new ToLowerCase().toLowerCase("heooF"));

    }

    public String toLowerCase(String str) {
        char[] str1 = str.toCharArray();

        for(int i=0; i<str1.length; i++) {
            if(str1[i] > 'A' && str1[i] < 'Z') {
                str1[i] +=32;
            }
        }
        return String.valueOf(str1);
    }
}
