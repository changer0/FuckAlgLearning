package com.lulu.leetcode.二叉树._404_左叶子之和;

import com.lulu.leetcode.二叉树.TreeNode;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        System.out.println(new Solution().sumOfLeftLeaves(root));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        if (root.left == null) return sum;
        if (root.left.left == null && root.left.right == null) sum += root.left.val;
        return sum;
    }
}
