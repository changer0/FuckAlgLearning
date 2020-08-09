package com.lulu.leetcode.二叉树._104_二叉树的最大深度;

import com.lulu.leetcode.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    static class Entity {
        int level; //层数
        TreeNode node;//节点
        public Entity(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }
    //DFS 非递归实现 模拟系统栈
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int max = Integer.MIN_VALUE;
        Stack<Entity> stack = new Stack<>();
        stack.push(new Entity(1, root));
        while (!stack.isEmpty()) {
            Entity entity = stack.pop();
            TreeNode node = entity.node;
            int level = entity.level;
            if (node.right != null) {
                stack.push(new Entity(level + 1, node.right));
            }
            if (node.left != null) {
                stack.push(new Entity(level + 1, node.left));
            }
            max = Math.max(level, max);
        }

        return max;
    }

    //BFS 广度优先遍历
    public int maxDepth3(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int ret = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            //获取当前队列的个数，正好是每一层的个数
            for (int size = q.size(); size > 0; size-- ) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            ret++;
        }
        return ret;
    }

    //DFS 递归解法
    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepath = maxDepth(root.right);
        return Math.max(leftDepth, rightDepath) + 1;
    }
}