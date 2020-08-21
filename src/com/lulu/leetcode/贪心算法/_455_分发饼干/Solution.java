package com.lulu.leetcode.贪心算法._455_分发饼干;

import java.util.Arrays;

/**
 *
 */
public class Solution {
    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 2};
        System.out.println(new Solution().findContentChildren(g, s));

    }

    //贪心算法
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gLen = g.length;
        int sLen = s.length;
        int gi = gLen-1, si = sLen-1, res = 0;
        while (gi >= 0 && si >= 0) {
            if (s[si] > g[gi]) {//满足当前小孩的胃口
                si--;
                gi--;
                res++;
            } else {
                gi--;
            }
        }
        return res;
    }
}
