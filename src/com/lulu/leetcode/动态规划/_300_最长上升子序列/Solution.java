package com.lulu.leetcode.动态规划._300_最长上升子序列;

import java.util.Arrays;

/**
 *
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 0) return 0;
        //dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);//默认填充 1
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}