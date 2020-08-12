package com.lulu.leetcode.递归回溯法._77_组合;

import java.util.ArrayList;
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
    //递归回溯
    public List<List<Integer>> combine(int n, int k) {
        res.clear();
        if (n < 1 || n < k) return res;
        combine(n, 1, k, new LinkedList<>());
        return res;
    }
    private void combine (int n, int start, int k, LinkedList<Integer> p) {
        //递归终止条件
        if (p.size() == k) {
            res.add(new ArrayList(p));
            return;
        }

        for (int i = start; i <= n; i++) {
            p.push(i);
            combine(n, i+1, k, p);
            p.pop();
        }
    }
}
