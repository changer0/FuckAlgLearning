package com.lulu.leetcode.二叉树._111_二叉树的最小深度;

import com.lulu.leetcode.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    //BFS 广度优先遍历，队列解决
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ret = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                //已经遍历到叶子节点了，直接返回
                if (node.left == null && node.right == null) {
                    return ret+1;
                }
                size--;
            }
            ret++;
        }
        return -1;
    }

    static class Entity {
        int level;
        TreeNode node;
        public Entity (int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }
    //DFS 非递归方式解决
    public int minDepth3(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        Stack<Entity> stack = new Stack<>();
        stack.push(new Entity(1, root));
        while (!stack.isEmpty()) {
            Entity entity = stack.pop();
            int level = entity.level;
            TreeNode node = entity.node;
            if (node.left != null) stack.push(new Entity(level+1, node.left));
            if (node.right != null) stack.push(new Entity(level+1, node.right));
            //叶子节点时，记录最短路径
            if (node.left == null && node.right == null) {
                min = Math.min(level, min);
            }
        }
        return min;
    }
    //DFS 递归方式解决
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDepth(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(minDepth(root.right), min);
        }
        return min+1;
    }
}