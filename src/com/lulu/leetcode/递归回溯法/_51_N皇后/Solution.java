package com.lulu.leetcode.递归回溯法._51_N皇后;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(4));
    }

    //当前列遍历标记
    private boolean col[];
    //对角线 1 遍历标记
    private boolean diagonal1[];
    //对角线 2 遍历标记
    private boolean diagonal2[];
    //存储结果
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        diagonal1 = new boolean[n*2];
        diagonal2 = new boolean[n*2];
        res = new ArrayList<>();
        solveNQueens(n, 0, new HashMap<>());
        return res;
    }

    //index: 第 index 行
    //row: 存储结果，row[k] = t 表示 k 行 t 列 放置了皇后！
    private void solveNQueens(int n, int index, Map<Integer, Integer> row) {

        //遍历到行末就可以返回 N 皇后的一个解
        if (index == n) {
            generateResult(n, row);
            return;
        }

        //此处表示第 i 列
        for (int i = 0; i < n; i++) {
            if (!col[i] && !diagonal1[index+i] && !diagonal2[index-i+n-1]) {
                row.put(index, i);
                //各标记位全设置位 true
                col[i] = true;
                diagonal1[index+i] = true;
                diagonal2[index-i+n-1] = true;
                solveNQueens(n, index+1, row);
                //递归结束后，标记位回溯
                col[i] = false;
                diagonal1[index+i] = false;
                diagonal2[index-i+n-1] = false;
                row.remove(index);
            }
        }
    }
    //生成结果 row[k] = t 表示 k 行 t 列 放置了皇后！
    private void generateResult(int n, Map<Integer, Integer> row) {
        //遍历
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (row.get(i) == j)
                    builder.append("Q");
                else
                    builder.append(".");
            }
            stringList.add(builder.toString());
        }
        res.add(stringList);
    }


}