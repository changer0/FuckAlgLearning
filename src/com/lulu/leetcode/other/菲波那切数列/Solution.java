package com.lulu.leetcode.other.菲波那切数列;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
public class Solution {
    public static void main(String[] args) {
        //System.out.println(new Solution().fib1(100));
        System.out.println(new Solution().fib2(10));
        System.out.println(new Solution().fib3(10));
    }

    /**
     * 暴力递归
     * @param N
     * @return
     */
    public int fib1(int N) {
        if (N == 1 || N == 2) {
            return 1;
        }
        return fib1(N-1) + fib1(N-2);
    }

    /**
     * 带备忘录的递归解法
     * @param N
     * @return
     */
    public int fib2(int N) {
        return dp2(N, new HashMap<>());
    }

    private int dp2(int N, Map<Integer, Integer> memo) {
        if (N < 0) {
            return 0;
        }
        if (N == 1 || N == 2) {
            return 1;
        }
        Integer memoN = memo.get(N);
        if (memoN != null) {
            return memoN;
        }
        int value = dp2(N - 1, memo) + dp2(N - 2, memo);
        memo.put(N, value);
        return value;
    }
    /**
     * dp 数组的迭代解法
     * @param N
     * @return
     */
    public int fib3(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 2 || N == 1) {
            return 1;
        }
        int num = 1, pre = 1, cur = 1;
        for (int i = 3; i <= N; i++) {
            num = pre + cur;
            pre = cur;
            cur = num;
        }
        return num;
    }
}
