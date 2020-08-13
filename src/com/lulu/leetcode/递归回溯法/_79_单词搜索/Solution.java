package com.lulu.leetcode.递归回溯法._79_单词搜索;

/**
 *
 */
class Solution {
    public static void main(String[] args) {
        char[][] chars = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(new Solution().exist(chars, "SEE"));
    }

    //m: 行 n: 列
    private int m, n;
    //存储是否访问过
    boolean[][] visited;
    //技巧点: 用来表示每个方向移动的长度(上、右、下、左)
    int[][] dis = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    //回溯
    public boolean exist(char[][] board, String word) {
        if (board.length <= 0) return false;
        m = board.length;//行 x
        n = board[0].length;//列 y
        visited = new boolean[m][n];


        //从每一个节点开始遍历
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //j i 的定义要明确
                if (exist(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    //方法定义: 用来根据当前节点寻找是否存在 word 的路径
    //wordIndex: 目标单词的索引
    //startX: 当前开始遍历的横坐标
    //startY: 当前开始遍历的纵坐标
    private boolean exist(char[][] board, String word, int wordIndex, int startX, int startY) {
        //递归终止条件：当 wordIndex 已经访问到最后一个时
        if (wordIndex == word.length() - 1) {
            //取决于最有一个元素是否和 startX 和 startY 位置的值是否一致
            return board[startX][startY] == word.charAt(wordIndex);
        }
        //当前位置符合要求
        if (word.charAt(wordIndex) == board[startX][startY]) {
            visited[startX][startY] = true;//记录当前位置已经访问过了
            //开始从 4 个方向进行尝试
            for (int i = 0; i < 4; i++) {
                int newX = startX + dis[i][0];
                int newY = startY + dis[i][1];
                //判断新位置的合法性、是否已经访问过
                //System.out.println("newX: " + newX);
                //System.out.println("newY: " + newY);
                //System.out.println("m: " + m);
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    if (exist(board, word, wordIndex+1, newX, newY)) {
                        return true;
                    }
                }
            }
            visited[startX][startY] = false;//回溯设置为未访问状态
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}