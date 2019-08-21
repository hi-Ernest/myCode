package com.leetcode.StringManipulation;


public class LongestPalindrome {

    public static void main(String[] args) {

//        System.out.println(LongestPalindrome("huhubb"));

        System.out.println(isIsomorphic("eeq", "add"));
    }

    /**
     * 字符串集合可以组成的回文字符串的最大长度
     *
     * Input : "abccccdd"
     * Output : 7
     * Explanation : One longest palindrome that can be built is "dccaccd", whose length is 7.
     *
     *
     * @param s
     * @return
     */
    public static int LongestPalindrome(String s) {

        int[] cnts = new int[256];

        for (char c : s.toCharArray()) {
            cnts[c]++;
        }

        int palindrome = 0;
        for (int c : cnts) {
            palindrome+= (c/2)*2;
        }


        //这个条件下s中一定有单个未使用的字符存在
        if (palindrome < s.length()) {
            palindrome++;
        }

        return palindrome;
    }


    /**
     * 字符串同构
     *
     * Given "egg", "add", return true.
     * Given "foo", "bar", return false.
     * Given "paper", "title", return true.
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s, String t) {
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (preIndexOfS[sc] != preIndexOfT[tc]) {
                return false;
            }
            preIndexOfS[sc] = i + 1;
            preIndexOfT[tc] = i + 1;
        }
        return true;
    }


}
