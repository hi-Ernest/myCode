package com.leetcode.stringManipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 *
 *
 */
public class VaildAnagram {

    public static boolean isAnagram(String s, String t) {
        int[] cnts = new int[26];

        for (char c : s.toCharArray()) {
            cnts[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            cnts[c - 'a']--;
        }

        for (int cnt : cnts) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }


    public static boolean isAnagram_2(String s, String t) {

        Map<String, Integer> notepad = new HashMap<>();

        for (char c : s.toCharArray()) {
//            notepad.put();
        }

        return true;
    }

}
