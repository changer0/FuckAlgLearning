package com.lulu.leetcode.动态规划._198_打家劫舍;

/**
 *
 */
public class Solution {
    public static void main(String[] args) {
        boolean[][] visit = new boolean[20][30];


    }

    //动态规划
    public int rob(int[] nums) {
        int len = nums.length;
        if (len <= 0) return 0;
        //存储 [0, len-1] 中的价值
        int[] dp = new int[len];
        //只有一个房子时，把最后一个房子的价值放进来
        dp[len - 1] = nums[len - 1];
        for (int i = len-1; i >= 0; i--) {
            //计算dp[i] 从 i 房子开始偷时
            for (int j = i; j < len; j++) {
                dp[i] = Math.max(dp[i], (j + 2 < len ? dp[j+2] : 0) + nums[j]);
            }
        }
        return dp[0];
    }


    //记忆数组
    private Integer[] memo;
    //递归 + 记忆化
    public int rob2(int[] nums) {
        memo = new Integer[nums.length];
        return dfs(nums, 0);
    }
    //函数定义：返回 nums 中 [index, nums.length - 1] 中最大的价值
    private int dfs(int[] nums, int index) {
        //递归终止条件
        if (index >= nums.length) return 0;
        if (memo[index] != null) return memo[index];
        int res = -1;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + dfs(nums, i + 2));
        }
        memo[index] = res;
        return res;
    }
}
