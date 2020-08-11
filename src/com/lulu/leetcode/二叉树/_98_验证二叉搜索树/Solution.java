package com.lulu.leetcode.二叉树._98_验证二叉搜索树;

import com.lulu.leetcode.二叉树.TreeNode;

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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        TreeNode leftMax = getMax(root.left);
        TreeNode rightMin = getMin(root.right);
        if (leftMax == null && rightMin == null) {
            return true;
        }
        if (leftMax == null && root.val >= rightMin.val) {
            return false;
        }
        if (rightMin == null && root.val <= leftMax.val) {
            return false;
        }
        if (leftMax != null && rightMin != null) {
            if (root.val >= rightMin.val || root.val <= leftMax.val) {
                return false;
            }
        }
        boolean leftIsBST = isValidBST(root.left);
        boolean rightIsBST = isValidBST(root.right);
        return leftIsBST && rightIsBST;
    }
    //获取最大值
    private TreeNode getMax(TreeNode root) {
        if (root == null) return null;
        if (root.right == null) return root;
        return getMax(root.right);
    }
    //获取最小值
    private TreeNode getMin(TreeNode root) {
        if (root == null) return null;
        if (root.left == null) return root;
        return getMax(root.left);
    }
}