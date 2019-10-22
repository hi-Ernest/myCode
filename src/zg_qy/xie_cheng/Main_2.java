package zg_qy.xie_cheng;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main_2 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static boolean CheckBlackList(String userIP, String blackIP) {

        char[] blackIPs = blackIP.toCharArray();
        String s = blackIP;


        int index = blackIPs.length-1;
        while (index > 0) {
            if (blackIPs[index] == '.') {
                s = blackIP.substring(0, index);
                break;
            }
            index--;
        }

        char[] userIPs = userIP.toCharArray();
        String us =userIP;

        int index3 = userIPs.length-1;
        while (index3 > 0) {
            if (userIPs[index3] == '.') {
                s = userIP.substring(0, index3);
                break;
            }
            index3--;
        }

        char[] uss = us.toCharArray();
        char[] ss = s.toCharArray();

        if (uss.length != ss.length)
            return false;

        int len = uss.length;

        for (int i=0; i<len; i++) {
            if (uss[i] != ss[i]) {
                return false;
            }
        }

        String t = blackIP.substring(index+1, blackIP.length());
        char[] tt = t.toCharArray();
        int index2 = tt.length-1;
        while (index2>0) {
            if (tt[index2] == '/') {
                break;
            }
            index2--;
        }

        int min = Integer.valueOf(t.substring(0,index2));
        int max = Integer.valueOf(t.substring(index2+1,t.length()));
        int v = Integer.valueOf(userIP.substring(index3+1, userIP.length()));

        if (v<min || v>max) {
            return false;
        }
        return true;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean res;

        String _userIP;
        try {
            _userIP = in.nextLine();
        } catch (Exception e) {
            _userIP = null;
        }

        String _blackIP;
        try {
            _blackIP = in.nextLine();
        } catch (Exception e) {
            _blackIP = null;
        }

        res = CheckBlackList(_userIP, _blackIP);
        System.out.println(String.valueOf(res ? 1 : 0));
    }
}

