package base.algorithm;

import java.util.Stack;

public class HammingDistance {

    public static void main(String[] args) {
//        System.out.println(new HammingDistance().getBin(4));
//        String str = String.format("%04d", 1);
//        System.out.println(str);
        System.out.println(new HammingDistance().hammingDistance(2, 4));
    }

    public int hammingDistance(int x, int y) {
        String strX = getBin(x);
        String strY = getBin(y);

        char[] change;
        int count = 0;
        int len = strX.length()>strY.length()? strX.length() : strY.length();
        char[] other = new char[len+1];

        if(strX.length() < strY.length()) {
            int num = strY.length() - strX.length()+1;
            System.out.println(num);
//            change = String.format("%0"+num+"d", Integer.valueOf(strX)).toCharArray();
            other = strY.toCharArray();

            System.out.println(String.format("%0"+num+"d", Integer.valueOf(strX))+" " +strY);

        }else {
            int num = strX.length() - strY.length()+1;
            change = String.format("%0"+num+"d", Integer.valueOf(strY)).toCharArray();
            other = strX.toCharArray();
        }

        int i=0;
//        while (i <change.length) {
//            if(change[i] != other[i])
//                count++;
//            i++;
//        }
        return count;
    }

    public String getBin(int a) {

        Stack stack = new Stack();

        while (a!=0) {
            stack.push(a%2);
            a/=2;
        }

        String str = "";
        while (!stack.empty()) {
            str+=""+stack.pop();
        }
        return str;
    }
}
