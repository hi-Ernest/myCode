package com.leetcode.medium;

/**
 * @author Ernest Chen
 * @date 2020/6/4.
 */
public class MumIslands {
    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        int count = 0;

        if (m <= 0) {
            return 0;
        }

        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j =0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        dfs(i+1, j, grid);
        dfs(i, j-1, grid);
        dfs(i, j+1, grid);
        dfs(i-1, j, grid);
    }

    public static void main(String[] args) {
        char[][] input = {{'1','1','1','1','0'},
                          {'1','1','0','1','0'},
                          {'1','1','0','0','0'},
                          {'0','0','0','0','0'}};
        System.out.println(new MumIslands().numIslands(input));
    }
}
