package com.lulu.leetcode.动态规划._416_分割等和子集;

/**
 *
 */
class Solution {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(new Solution().canPartition(nums));
    }
    //动态规划思路解决
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum%2 != 0) {
            return false;
        }
        int C = sum/2;
        boolean[] dp = new boolean[C + 1];
        //先赋初值
        for (int i = 0; i <= C; i++) {
            dp[i] = (nums[0] == i);
        }
        for (int i = 1; i < n; i++) {
            for (int j = C; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[C];
    }
}