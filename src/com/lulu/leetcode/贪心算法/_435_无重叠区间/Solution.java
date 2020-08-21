package com.lulu.leetcode.贪心算法._435_无重叠区间;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 */

//[ [1,2], [2,3], [3,4], [1,3] ]
//将问题转换为：找到最长的不重叠子序列
class Solution {
    public static void main(String[] args) {
        int[][] input = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        //int[][] input = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println(new Solution().eraseOverlapIntervals(input));
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 0) {
            return 0;
        }
        Arrays.sort(intervals, (int[] o1, int[] o2) -> {
            return o1[0] - o2[0];
        });
        int rowLen = intervals[0].length;
        //dp[i]表示 [0 .. i] 中最长的不重叠子序列的个数
        int[] dp = new int[intervals.length];
        Arrays.fill(dp, 1);//默认最长不重叠都是 1
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][rowLen-1] ) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(dp[i], res);
        }
        return intervals.length - res;
    }
}