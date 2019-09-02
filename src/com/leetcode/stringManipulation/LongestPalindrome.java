package com.leetcode.stringManipulation;


import java.util.HashMap;
import java.util.Map;

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


    //计数器
    private int count = 0;

    /**
     * 回文子字符串的个数
     *
     * Input: "aaa"
     * Output: 6
     * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        for (int i=0; i<s.length(); i++) {
           extendSubstrings(s, i, i); //奇数长度
           extendSubstrings(s, i, i+1); //偶数长度
        }

        return count;
    }

    private void extendSubstrings(String s, int begin, int end) {
        while (begin >=0 && end <s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
            count++;
        }
    }


    public String longestPalindrome(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);

            if (map.containsKey(c)) {

            }

            map.put(c, i+1);

        }


        return s;
    }


    /**
     * 判断是否是回文字串
     * @param s
     * @return
     */
    private boolean isPalindromic(String s) {

        int len = s.length();
        for (int i=0; i< len / 2; i++) {

            if (s.charAt(i) != s.charAt(len - i + 1)) {
                return false;
            }
        }
        return true;
    }

    //暴力解决
    public String longstPalindrome_violecne(String s) {

        int len = s.length();
        int max = 0;
        String ans = "";

        for (int i=0; i < len; i++) {
            for (int j = i+1; j < len - 1; j++) {
                String str = s.substring(i, j);

                if (isPalindromic(str) && str.length() > max) {
                    ans = str;
                    max = Math.max(max, ans.length());
                }
            }
        }

        return ans;
    }


}
