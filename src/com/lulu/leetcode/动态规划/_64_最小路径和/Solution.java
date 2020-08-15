package com.lulu.leetcode.动态规划._64_最小路径和;

/**
 *
 */
class Solution {
    public static void main(String[] args) {
//        int[][] input = {
//                {1, 2},
//                {1, 1}
//        };
        int[][] input = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new Solution().minPathSum(input));
    }

    //动态规划
    private int m, n;
    //下 右
    private int[][] dis = {{1, 0}, {0, 1}};
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int col = m-1; col >= 0; col--) {
            for (int row = n-1; row >= 0; row--) {
                dp[col][row] = Integer.MAX_VALUE;
                for (int i = 0; i < 2; i++) {
                    int newCol = col + dis[i][0];
                    int newRow = row + dis[i][1];
                    if (newCol == m) continue;
                    if (newRow == n) continue;
                    dp[col][row] = Math.min(dp[col][row], dp[newCol][newRow] + grid[col][row]);
                }
                if (dp[col][row] == Integer.MAX_VALUE) {
                    dp[col][row] = grid[col][row];
                }
            }
        }
        return dp[0][0];
    }

    //------------------------------------------------------------------------------------------------------------------
    // 记忆化 start

    public int minPathSum2(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        memo = new Integer[m+1][n+1];
        return dfs(grid, 0, 0);
    }
    private Integer[][] memo;
    //返回最小和
    private int dfs(int[][] grid, int col, int row) {
        if (col == m || row == n) {
            return 0;
        }
        if (memo[col][row] != null) return memo[col][row];
        int minSum = Integer.MAX_VALUE;
        //往两个方向延伸
        for (int i = 0; i < 2; i++) {
            int newCol = col + dis[i][0];
            int newRow = row + dis[i][1];
            if (newCol == m) continue;
            if (newRow == n) continue;
            minSum = Math.min(minSum, dfs(grid, newCol, newRow) + grid[col][row]) ;
        }
        if (minSum == Integer.MAX_VALUE) {
            minSum = grid[col][row];
        }
        memo[col][row] = minSum;
        return minSum;
    }
}