package com.lulu.leetcode.动态规划._120_三角形最小路径和;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-dp-bi-xu-miao-dong-by-sweetiee/
 * 这个题解是不错！！！！
 */
public class Solution {


    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);

//        List<Integer> list1 = new ArrayList<>();
//        list1.add(-1);
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(2);
//        list2.add(3);
//        List<Integer> list3 = new ArrayList<>();
//        list3.add(1);
//        list3.add(-1);
//        list3.add(-3);


        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
//        triangle.add(list5);
        System.out.println(triangle);
        System.out.println(new Solution().minimumTotal(triangle));

    }


    public int minimumTotal(List<List<Integer>> triangle) {
        //动态规划 状态方程：dp[i][j] = min(dp[i+1][j], dp[i+1][j+1]) + triangel[i][j];
        int size = triangle.size();
        int[][] dp = new int[size+1][size+1];

        //这个 i 表示行
        for (int i = size-1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                //最后一行都是零
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
        //备忘录 + 递归
        // memeo = new Integer[triangle.size()][triangle.size()];
        // return dfs(triangle, 0, 0);
    }

    //备忘录 + 递归
    private Integer[][] memeo;
    // colIndex: 行索引
    // rowIndex: 列索引
    // 返回值: 当前 colIndex rowIndex 所对应的最小路径和
    private int dfs(List<List<Integer>> triangle, int colIndex, int rowIndex) {
        //递归终止条件：已经遍历到行末尾
        if (colIndex == triangle.size()) {
            return 0;
        }
        if (memeo[colIndex][rowIndex] != null) {
            return memeo[colIndex][rowIndex];
        }
        int minSum = Math.min(dfs(triangle, colIndex + 1, rowIndex)
                , dfs(triangle, colIndex + 1, rowIndex + 1));
        memeo[colIndex][rowIndex] = minSum + triangle.get(colIndex).get(rowIndex);
        return memeo[colIndex][rowIndex];
    }

}
