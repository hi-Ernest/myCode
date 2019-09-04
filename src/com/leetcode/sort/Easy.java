package com.leetcode.sort;

import java.lang.reflect.Array;
import java.util.*;

public class Easy {

    public static void main(String[] args) {

//        int[] a = {1, 2, 2, 1};
//        int[] b = {2, 2};

        String s1 = "anagram", s2 = "nagaram";

        int[] a = {2,3,1,3,2,4,6,7,9,2,19};
        int[] b = {2,1,4,3,9,6};

        Easy easy = new Easy();

        int[] result = easy.intersect_sort(a, b);

//        System.out.println(Arrays.toString(result));

//        easy.isAnagram(s1 , s2);


        easy.relativeSortArray(a, b);
    }

    //使用HashMap
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {

            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }

        int temp = 0;
        for (int j = 0; j < nums2.length; j++) {
            if (map.containsKey(nums2[j]) && map.get(nums2[j]) != 0) {
                map.put(nums2[j], map.get(nums2[j]) - 1);
                list.add(nums2[j]);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }


    //排序
    public int[] intersect_sort(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return null;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int len1 = nums1.length, len2 = nums2.length;
        int[] temp = new int[len1 > len2 ? len2 : len1];

        int i = 0, j = 0, k = 0;

        while (i < len1 && j < len2) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                temp[k] = nums1[i];
                k++;
                i++;
                j++;
            }
        }

//        System.out.println(Arrays.toString(temp));

        int[] result = new int[k];
        for (int r = 0; r < k; r++) {
            result[r] = temp[r];
        }

        return result;
    }


    /**
     * 能组成三角形的最大周长
     * 我们假设三角形的边长满足 a≤b≤c。那么这三条边组成三角形的面积非零的充分必要条件是 a + b > ca+b>c
     *
     * @param A
     * @return
     */
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);

        for (int i = A.length - 3; i >= 0; i--) {
            if (A[i] + A[i + 1] > A[i + 2]) {
                return A[i] + A[i + 1] + A[i + 2];
            }
        }
        return 0;
    }


    /**
     * 给定两个字符串 s 和 t
     * 编写一个函数来判断 t 是否是 s 的字母异位词
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {

        char[] charsS = s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charsS);
        Arrays.sort(charT);

        if (charsS.length != charT.length)
            return false;

//        for (int i=0; i<charsS.length; i++) {
//            if (charsS[i] != charT[i])
//                return false;
//        }

        if (!Arrays.equals(charsS, charT))
            return false;

        return true;
    }


    public boolean isAnagram_2(String s, String t) {
        int[] counts = new int[26];

        if (s.length() != t.length())
            return false;


        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    //        Map<Integer, Integer> map = new HashMap<>();
//        Map<Integer, Integer> map2 = new HashMap<>();
//
//        List<Integer> list = new LinkedList<>();
//
//        for (int i=0; i<arr2.length; i++) {
//            map.put(arr2[i], arr2[i]);
//        }
//
//        System.out.println(map);
//
//        for (int j=0; j<arr1.length; j++) {
//            if (map.containsKey(arr1[j])) {
//                    map2.put(arr1[j],1);
//            }else {
//                list.add(arr1[j]);
//            }
//        }
//
//        System.out.println(map2);
//
//
//        int[] result = new int[arr1.length];
//
//        int index =0;
//        for (int key : map.keySet()) {
//            int value = map.get(key);
//
//            for (int i=0; i<value; i++) {
//                result[index++] = key;
//
//            }
//        }
//
//        for (int temp : list) {
//            result[index++] = temp;
//        }
//
//        return result;
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] backet = new int[1001];

        int[] result = new int[arr1.length];

        for (int i=0; i<arr1.length; i++) {
            backet[arr1[i]]++;
        }

        int cnt = 0;
        for (int i=0; i<arr2.length; i++) {
            while (backet[arr2[i]] > 0) {
                result[cnt++] = arr2[i];
                backet[arr2[i]]--;
            }
        }

        for (int j=0; j<1001; j++) {
            while (backet[j] != 0) {
                result[cnt++] = j;
                backet[j]--;
            }
        }

        return result;
    }
}
