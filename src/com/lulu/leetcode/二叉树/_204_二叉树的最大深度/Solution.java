package com.lulu.leetcode.二叉树._204_二叉树的最大深度;


import com.lulu.leetcode.二叉树.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepath = maxDepth(root.right);
        return Math.max(leftDepth, rightDepath) + 1;
    }
}
