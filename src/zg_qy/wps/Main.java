//package zg_qy.wps;
//
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
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
//
//    }
//
//    public int getResult(int[] nums, int m, int n) {
//        int[][] dp = new int[n][m+1];
//
//        for (int i=0; i<=nums.length; i++) {
//            dp[0][i] = 1;
//        }
//
//        for (int i=1; i<n; i++) {
//            for (int j=0; j<=m; j++) {
//                for (int k=0; k<=nums[i]; k++) {
//                    if (j >= k) {
//                        dp[i][j] += dp[i-1][j-k];
//                    }
//                }
//            }
//        }
//
//        return dp[n-1][m];
//    }
//
//}
