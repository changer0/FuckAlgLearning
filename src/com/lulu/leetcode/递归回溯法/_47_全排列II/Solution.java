package com.lulu.leetcode.递归回溯法._47_全排列II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class Solution {
    public static void main(String[] args) {
        String[] strings = new String[4];

    }
    //返回值
    private List<List<Integer>> res = new ArrayList<>();
    //用于检查当前元素是否使用
    private boolean[] used;
    //回溯法
    public List<List<Integer>> permuteUnique(int[] nums) {
        res.clear();
        if (nums.length <= 0) return res;
        used = new boolean[nums.length];
        permuteUnique(nums, new LinkedList<>());
        return res;
    }
    // p 用于记录符合要求的排列
    private void permuteUnique(int[] nums, LinkedList<Integer> p) {
        //递归终止条件
        if (p.size() == nums.length) {
            res.add(new ArrayList<>(p));
            return;
        }

        //用于过滤重复内容
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            //如果在本次递归中被使用，直接忽略
            if (used[i]) continue;
            //过滤重复
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            p.push(nums[i]);
            used[i] = true;
            permuteUnique(nums, p);
            p.pop();
            used[i] = false;
        }
    }

}
