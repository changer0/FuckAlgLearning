package com.lulu.leetcode.other.零钱兑换;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/coin-change/
 */
public class Solution {
    public static void main(String[] args) {
        //System.out.println("暴力破解 最少个数：" + new Solution().coinChange1(new int[]{1, 2, 5}, 100));
        //System.out.println("备忘录 最少个数：" + new Solution().coinChange2(new int[]{1,2,5}, 100));
        System.out.println("DP TABLE 最少个数：" + new Solution().coinChange3(new int[]{1,2,5}, 100));
        System.out.println("DP TABLE 最少个数：" + new Solution().coinChange3(new int[]{2}, 3));
    }
    /**
     * 暴力破解
     * @param coins 面值
     * @param amount 金额
     * @return 最少个数
     */
    public int coinChange1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int num = coinChange1(coins, amount - coins[i]);
            if (num == -1) {
                continue;
            }
            ret = Math.min(num+1, ret);
        }
        if (ret == Integer.MAX_VALUE || ret == -1) {
            return -1;
        }
        return ret;
    }


    /**
     * 备忘录优化
     * @param coins 面值
     * @param amount 金额
     * @return 最少个数
     */
    public int coinChange2(int[] coins, int amount) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return dp2(coins, amount, memo);
    }

    private int dp2(int[] coins, int amount, HashMap<Integer, Integer> memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        Integer memoAmount = memo.get(amount);
        if (memoAmount != null) {
            return memoAmount;
        }
        int ret = Integer.MAX_VALUE;
        for (int coin : coins) {
            int num = dp2(coins, amount - coin, memo);
            if (num == -1) {
                continue;
            }
            ret = Math.min(num + 1, ret);
        }
        if (ret == Integer.MAX_VALUE || ret == -1) {
            return -1;
        }
        memo.put(amount, ret);
        return ret;
    }

    /**
     * dp 数组迭代
     * @param coins 面值
     * @param amount 金额
     * @return 最少个数
     */
    public int coinChange3(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                int subAmount = i - coin;
                if (subAmount < 0) {
                    continue;
                }

                //选一个最小值
                dp[i] = Math.min(dp[subAmount]+1, dp[i]);
            }
        }
        if (dp[amount] == amount+1) {
            return -1;
        }
        return dp[amount];
    }
}
