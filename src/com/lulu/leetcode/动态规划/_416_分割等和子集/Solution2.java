package com.lulu.leetcode.动态规划._416_分割等和子集;

/**
 *
 */
//类 0-1 背包问题
//填满容量为 sum/2 的背包 nums[i]：表示第 i 个物品的重量
class Solution2 {
    private Boolean[][] memo;
    //递归-记忆化解决
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        //如果是奇数不可能分割
        if (sum%2 != 0) {
            return false;
        }
        memo = new Boolean[n][sum/2 + 1];
        return dfs(nums, n-1, sum/2);
    }
    //函数定义：返回往容量为 c 的背包中放入 [0 .. index] 是否可填满
    private boolean dfs(int[] nums, int index, int c) {
        //如果容量为空，说明正好填满
        if (c == 0) {
            return true;
        }
        //此时没有容量或者没有物品填充了，不可填满
        if (c < 0 || index < 0) {
            return false;
        }
        if (memo[index][c] != null) {
            return memo[index][c];
        }
        boolean res = dfs(nums, index-1, c) || dfs(nums, index-1, c - nums[index]);
        memo[index][c] = res;
        return res;
    }
}