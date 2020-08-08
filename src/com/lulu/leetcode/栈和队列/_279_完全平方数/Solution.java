package com.lulu.leetcode.栈和队列._279_完全平方数;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/perfect-squares/
 *
 * 利用图的 BFS 求解最短路径
 * 图的节点表示当前的值，图的边表示从节点到节点需要 i^2
 */
class Solution {
    //节点包装类
    static class Node {
        int value;//当前值
        int step;//步长
        public Node(int value, int step) {
            this.value = value;
            this.step = step;
        }
    }
    // BFS（广度优先遍历）寻找最短路径
    public int numSquares(int n) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n, 0));
        boolean[]  visited = new boolean[n+1];
        for(int i = 0; i < n+1; i++) {
            visited[i] = false;
        }
        while(!q.isEmpty()) {
            Node node = q.poll();
            // if(node.value == 0) {
            //     return node.step;
            // }
            for(int i = 1; node.value - i*i >= 0; i++) {
                int k = node.value - i*i;
                if(visited[k]) {
                    continue;
                }
                visited[k] = true;
                if(k == 0) {
                    return node.step + 1;
                }
                q.offer(new Node(k, node.step + 1));
            }
        }
        throw new RuntimeException("no found Solution");
    }
}
