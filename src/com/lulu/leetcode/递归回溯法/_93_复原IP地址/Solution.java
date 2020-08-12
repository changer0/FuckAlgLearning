package com.lulu.leetcode.递归回溯法._93_复原IP地址;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("25525511135"));
        System.out.println(new Solution().restoreIpAddresses("010010"));
    }


    //返回数组
    private List<String> res = new ArrayList<>();
    //第 n 段的值
    private int[] segments = new int[4];
    //递归回溯
    public List<String> restoreIpAddresses(String s) {
        res.clear();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        restoreIpAddresses(s, 0, 0);
        return res;
    }
    //segId 第几段 segStart 遍历开始索引
    private void restoreIpAddresses(String s, int segId, int segStart) {
        if (segId == 4) {
            //此时说明已经满足 4 段 且 当前遍历的位置已经指向末尾了
            if (segStart == s.length()) {
                StringBuilder stringBuilder = new StringBuilder();
                //此时可以记录下符合要求的 IP 地址
                stringBuilder
                        .append(segments[0]).append(".")
                        .append(segments[1]).append(".")
                        .append(segments[2]).append(".")
                        .append(segments[3]);
                String str = stringBuilder.toString();
                //主要是解决 0 的问题
                if (str.length() == s.length() + 3) {
                    res.add(str);
                }
            }
            return;
        }
        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        //针对普通场景
        int sum = 0;
        for (int i = segStart; i < s.length(); i++) {
            sum = sum * 10 + (s.charAt(i) - '0');
            if (sum < 0 || sum > 255) break;
            //System.out.println("i: " + i + " segId:" + segId + " sum:" + sum);
            segments[segId] = sum;//记录当前第 segId 段的值
            restoreIpAddresses(s, segId+1, i+1);//开始下一段的遍历
        }

    }

    //循环暴力解法
    public List<String> restoreIpAddresses1(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        //abcd 表示分割的位数
        for (int a = 1; a < 4; a++)
            for (int b = 1; b < 4; b++)
                for (int c = 1; c < 4; c++)
                    for (int d = 1; d < 4; d++)
                        //只有当总位数等于传入的值相同时才进行下一步
                        if ( a + b + c + d == s.length()) {
                            int n1 = Integer.valueOf(s.substring(0, a));
                            int n2 = Integer.valueOf(s.substring(a, a+b));
                            int n3 = Integer.valueOf(s.substring(a+b, a+b+c));
                            int n4 = Integer.valueOf(s.substring(a+b+c, a+b+c+d));
                            if (n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255) {
                                StringBuilder builder = new StringBuilder();
                                builder.append(n1).append(".");
                                builder.append(n2).append(".");
                                builder.append(n3).append(".");
                                builder.append(n4);

                                //010010 解决这种场景："0.1.0.10"
                                String str = builder.toString();
                                if (str.length() == s.length() + 3) {
                                    res.add(str);
                                }
                            }
                        }
        return res;
    }
}
