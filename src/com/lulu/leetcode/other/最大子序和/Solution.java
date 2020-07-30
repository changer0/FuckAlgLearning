package com.lulu.leetcode.other.最大子序和;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray1(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(new Solution().maxSubArray2(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    /**
     * dp 数组解法
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }

        int maxNum = Integer.MIN_VALUE;
        for (int i : dp) {
            maxNum = Math.max(i, maxNum);
        }
        return maxNum;
    }

    /**
     * 优化解法
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        if (nums.length == 0) return 0;
        int dp_pre = nums[0];
        int dp_cur;
        int maxNum = dp_pre;
        for (int i = 1; i < nums.length; i++) {
            dp_cur = Math.max(nums[i], nums[i] + dp_pre);
            dp_pre = dp_cur;
            maxNum = Math.max(dp_cur, maxNum);
        }
        return maxNum;
    }

}
