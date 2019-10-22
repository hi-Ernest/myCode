
package zg_qy.du_xiao_man;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);

        int[] w = new int[N];
        int[] t = new int[N];

        for (int i=0; i<N; i++) {
            int temp = scanner.nextInt();
            w[i] = temp;
        }

        for (int i=0; i<N; i++) {
            int temp = scanner.nextInt();
            t[i] = temp;
        }

        System.out.println(W + " " + N);
        System.out.println(Arrays.toString(w));
        System.out.println(Arrays.toString(t));

        Main main = new Main();

        System.out.println(main.knapsack(W, N, w, t));

    }

    public int knapsack(int W, int N, int[] weights, int[] values) {
        int[] dp = new int[W+1];

        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];

            for (int j = W; j >= 1; j--) {
                if (j >= w) {
                    dp[j] = Math.max(dp[j], dp[j - w] + v);
                }
            }
        }
        return dp[W];
    }

}
