package com.lulu.leetcode.动态规划._70_爬楼梯;

/**
 *
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(2));
        System.out.println(new Solution().climbStairs(3));
        System.out.println(new Solution().climbStairs(4));
        System.out.println(new Solution().climbStairs(4));

        int[] a = new int[5];
    }

    //循环解法
    public int climbStairs(int n) {
        int[] meno = new int[n+1];
        if (n == 0 || n == 1) return 1;
        meno[0] = meno[1] = 1;
        for (int i = 2; i < n+1; i++) {
            meno[i] = meno[i-1] + meno[i-2];
        }
        return meno[n];
    }


    //备忘录解法
    private int[] meno;
    //n 表示每次台阶个数
    public int climbStairs1(int n) {
        meno = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            meno[i] = -1;
        }
        return search(n);
    }

    private int search(int n) {
        //递归终止条件
        if (n == 1 || n == 0) {
            return 1;
        }

        if (meno[n] != -1) {
            return meno[n];
        }
        int ret = search(n-1) + search(n-2);
        meno[n] = ret;
        return ret;
    }
}
