package zg_qy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String blackIP = "2.33.128.0/24";
        String s = blackIP;
        char[] blackIPs = blackIP.toCharArray();

        int index = blackIPs.length-1;
        while (index > 0) {
            if (blackIPs[index] == '.') {
                s = blackIP.substring(0, index);
                break;
            }
            index--;
        }
        System.out.println(s);
        System.out.println(blackIP.substring(index+1, blackIP.length()));
        System.out.println(blackIP);

        String t = blackIP.substring(index+1, blackIP.length());
        char[] tt = t.toCharArray();
        int index2 = tt.length-1;
        while (index2>0) {
            if (tt[index2] == '/') {
                break;
            }
            index2--;
        }

        System.out.println(t);
        System.out.println(index2);
        int min = Integer.valueOf(t.substring(0,index2));
        int max = Integer.valueOf(t.substring(index2+1,t.length()));



        System.out.println(min + " "+max);

//        Scanner scanner = new Scanner(System.in);
//
//        String[] input = scanner.nextLine().split(" ");
//        int n = Integer.parseInt(input[0]);
//        int m = Integer.parseInt(input[1]);
//
//        int[] nn = new int[n];
//
//        for (int i=0; i<n; i++) {
//            String[] str = scanner.nextLine().split(" ");
//            int li = Integer.parseInt(str[0]);
//            int ri = Integer.parseInt(str[1]);
//
//            m-=li;
//            nn[i] = ri - li;
//        }
//
//        Main main = new Main();
//
//        System.out.println(main.getResult(nn, m, n));

    }

    public int getResult(int[] nums, int m, int n) {
        int[][] dp = new int[n][m+1];

        for (int i=0; i<=nums.length; i++) {
            dp[0][i] = 1;
        }

        for (int i=1; i<n; i++) {
            for (int j=0; j<=m; j++) {
                for (int k=0; k<=nums[i]; k++) {
                    if (j >= k) {
                        dp[i][j] += dp[i-1][j-k];
                    }
                }
            }
        }

        return dp[n-1][m];
    }

}
