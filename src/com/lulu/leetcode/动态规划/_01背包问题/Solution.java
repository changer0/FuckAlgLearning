package com.lulu.leetcode.动态规划._01背包问题;

/**
 * 0-1 背包问题
 *
 * 有n个物品，它们有各自的重量和价值，现有给定容量的背包，如何让背包里装入的物品具有最大的价值总和？
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().knapsack01ForMomo(new int[]{1, 2, 3}, new int[]{6, 10, 12}, 5));
        System.out.println(new Solution().knapsack01ForDp(new int[]{1, 2, 3}, new int[]{6, 10, 12}, 5));
    }
    //记忆化
    private Integer[][] memo;
    // w: 重量 v：价值 C：容量
    public int knapsack01ForMomo(int[] w, int[] v, int C) {
        int len = w.length;
        memo = new Integer[len][C+1];
        return dfs(w, v, len-1, C);
    }
    //考虑两种情况，放进去和不放进去
    //函数定义：返回 [0 .. index] 最大价值和
    private int dfs(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0) {
            return 0;
        }
        if (memo[index][c] != null) return memo[index][c];
        //1. 不放进去
        int res = dfs(w, v, index-1, c);
        if (c >= w[index]) {
            //2. 放进去
            res = Math.max(res, v[index] + dfs(w, v, index-1, c - w[index]));
        }
        memo[index][c] = res;
        return res;
    }


    //动态规划
    public int knapsack01ForDp(int[] w, int[] v, int C) {
        int len = w.length;
        //表示在 i 个物品 j 的容量下最大价值
        int[][] dp = new int[len][C+1];
        //首先初始化放入第0号物品的价值
        for (int j = 0; j <= C; j++) {
            dp[0][j] = w[0] <= j ? v[0] : 0;
        }
        //从第1号物品开始，开始考虑是否放入
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= C; j++) {
                //先按照不放入背包计算
                dp[i][j] = dp[i-1][j];
                if (w[i] <= j) {
                    //可以放进背包，但是需要对比放进背包和不放进背包的价值
                    dp[i][j] = Math.max(dp[i-1][j], v[i] + dp[i-1][j-w[i]]);
                }
                
            }
        }
        return dp[len-1][C];
    }
}
