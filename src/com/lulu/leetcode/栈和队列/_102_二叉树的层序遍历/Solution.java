package com.lulu.leetcode.栈和队列._102_二叉树的层序遍历;

import com.lulu.leetcode.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
class Solution {
    static class RecordEntity {
        int level;
        TreeNode node;
        public RecordEntity(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }
    //使用队列 BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<RecordEntity> q = new LinkedList<>();
        q.offer(new RecordEntity(0, root));
        while(!q.isEmpty()) {
            RecordEntity record = q.poll();
            if(record.level == res.size()) {
                res.add(new ArrayList<Integer>());
            }
            res.get(record.level).add(record.node.val);
            if(record.node.left != null) {
                q.offer(new RecordEntity(record.level+1, record.node.left));
            }
            if(record.node.right != null) {
                q.offer(new RecordEntity(record.level+1, record.node.right));
            }
        }
        return res;
    }
}
