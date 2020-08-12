package com.lulu.leetcode.查找表问题._1_两数之和;

import java.util.HashMap;

/**
 *
 */
public class Solution {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        if (nums.length <= 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = map.getOrDefault(target - nums[i], -1);
            if (j != -1) {
                return new int[]{j, i};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
