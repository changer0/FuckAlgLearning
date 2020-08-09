package com.lulu.leetcode.二叉树._100_相同的树;

import com.lulu.leetcode.二叉树.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        boolean leftSample = isSameTree(p.left, q.left);
        boolean rightSample = isSameTree(p.right, q.right);

        return leftSample && rightSample && p.val == q.val;
    }
}