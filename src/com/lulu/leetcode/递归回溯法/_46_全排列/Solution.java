package com.lulu.leetcode.递归回溯法._46_全排列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1,2,3}));
    }


    private List<List<Integer>> res = new ArrayList<>();
    boolean[] used;//用于保存上一轮调用是否使用当前值
    //递归回溯法解决
    public List<List<Integer>> permute(int[] nums) {
        res.clear();
        if (nums.length <= 0) return res;
        used = new boolean[nums.length];
        permute(nums, 0, new LinkedList<Integer>());
        return res;
    }
    // count 用来记录遍历次数，用于终止递归  p 存放排列后的数据
    private void permute(int[] nums, int count, LinkedList<Integer> p) {

        if (count == nums.length) {
            //递归终止条件,已经遍历到一个组合
            res.add((new ArrayList<>(p)));
            return;
        }

        //遍历每一个值，另外需要过滤上轮使用过的值
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                used[i] = true;
                p.push(nums[i]);
                permute(nums, count+1, p);
                p.pop();//执行完成之后不要忘记取出来
                used[i] = false;
            }
        }
    }
}
