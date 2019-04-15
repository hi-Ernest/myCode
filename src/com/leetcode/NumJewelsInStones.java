package com.leetcode;

public class NumJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        char[] sNum = S.toCharArray();
        char[] jNum = J.toCharArray();
        for(int i=0; i<jNum.length; i++) {
            for(int j=0; j<sNum.length; j++) {
                if(jNum[i] == sNum[j])
                    count++;
            }
        }
        return count;
    }
}
