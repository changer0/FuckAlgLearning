package com.lulu.leetcode.二叉树._226_翻转二叉树;

import com.lulu.leetcode.二叉树.TreeNode;

/**
 *
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode treeNode = new Solution().invertTree(root);
        TreeNode.print2(root);
        System.out.println();
        TreeNode.print2(treeNode);
    }

    public TreeNode invertTree(TreeNode root) {
        TreeNode res = new TreeNode(root.val);
        invertTree(root, res);
        return res;
    }

    private void invertTree(TreeNode root, TreeNode res) {
        if(root == null) {
            return;
        }
        if (root.right != null) {
            res.left = new TreeNode(root.right.val);
        }
        if(root.left != null) {
            res.right = new TreeNode(root.left.val);
        }
        invertTree(root.left, res.right);
        invertTree(root.right, res.left);
    }
}
