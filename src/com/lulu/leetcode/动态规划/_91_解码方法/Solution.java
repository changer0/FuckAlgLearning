package com.lulu.leetcode.动态规划._91_解码方法;

/**
 *
 */
class Solution {
    public static void main(String[] args) {
//        System.out.println(new Solution().numDecodings("2262"));
//        System.out.println(new Solution().numDecodings("2232"));
        System.out.println(new Solution().numDecodings("122222"));
    }
    public int numDecodings(String s) {
        memo = new Integer[s.length() + 1];
        return dfs(s);
    }
    private Integer[] memo;
    // 方法定义：输入一串数字，返回它的解码总数
    private int dfs(String s) {
        int len = s.length();
        //递归终止条件
        if (len == 0) {
            return 0;
        }
        if (s.startsWith("0")) return 0;
        if (memo[len] != null) return memo[len];
        //剩下就分为两种情况
        //1. 单个数字
        int sum = 0;
        if (len < 3 && Integer.valueOf(s) <= 26 && Integer.valueOf(s) > 0) sum++;
        if (len > 1) {
            String endStr = s.substring(1, len);
            sum += dfs(endStr);
        }
        //2. 两个数字且不超过 26
        if (len > 2) {
            //取前两个字符串
            String two = s.substring(0, 2);
            if (two.length() < 3 && Integer.valueOf(two) <= 26 && Integer.valueOf(two) > 0) {
                String endStr = s.substring(2, len);
                sum += dfs(endStr);
            }

        }
        memo[len] = sum;
        return sum;
    }
}
