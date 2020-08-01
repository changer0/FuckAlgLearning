package com.lulu.leetcode.数组问题._283_移动零;


import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class Solution {
    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};
        new Solution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 0,1,0,3,12
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int k = 0;//记录非 0 index 后一位
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                if (k != i){
                    swap(nums, k++, i);
                } else {
                    k++;
                }
        }
    }

    /**
     * Swaps x[a] with x[b].
     */
    private static void swap(int[] x, int a, int b) {
        int t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

}
