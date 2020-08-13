package com.lulu.leetcode.递归回溯法._200_岛屿数量;

/**
 *
 */
class Solution {

    public static void main(String[] args) {
        char[][] in = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(new Solution().numIslands(in));
    }

    //技巧点: 用来表示每个方向移动的长度(上、右、下、左)
    private int[][] dis = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    //当前是否访问过
    private boolean[][] visited;
    //x y
    private int m, n;
    public int numIslands(char[][] grid) {
        if (grid.length <= 0) return 0;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    res++;
                    numIslands(grid, i, j);
                }
            }
        }
        return res;
    }

    private void numIslands(char[][] grid, int startX, int startY) {
        //递归终止条件
        if (!inArea(startX, startY) || grid[startX][startY] == '0' || visited[startX][startY]) {
            return;
        }

        visited[startX][startY] = true;
        for (int i = 0; i < 4; i++) {
            int newX = startX + dis[i][0];
            int newY = startY + dis[i][1];
            numIslands(grid, newX, newY);
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }


}
