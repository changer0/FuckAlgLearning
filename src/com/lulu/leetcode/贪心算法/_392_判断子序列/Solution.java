package com.lulu.leetcode.贪心算法._392_判断子序列;

/**
 *
 */
class Solution {
    //贪心算法？？？
    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int si = 0, ti = 0;
        if (sChars.length > tChars.length) {
            return false;
        }
        while (si < sChars.length && ti < tChars.length) {
            if (sChars[si] == tChars[ti]) {
                si++; ti++;
            } else {
                ti++;
            }
        }
        if (si != sChars.length) {
            return false;
        }

        return true;
    }
}
