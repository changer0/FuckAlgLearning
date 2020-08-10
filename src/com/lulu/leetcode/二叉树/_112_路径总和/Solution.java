package com.lulu.leetcode.二叉树._112_路径总和;

import com.lulu.leetcode.二叉树.TreeNode;

/**
 * https://leetcode-cn.com/problems/path-sum/
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return (sum-root.val) == 0;//如果是叶子节点，判断是否和为 0
        if (hasPathSum(root.left, sum - root.val)) return true;//左子树是否包含 当前和-当前值
        if (hasPathSum(root.right, sum - root.val)) return true;//右子树是否包含 当前和-当前值
        return false;
    }
}