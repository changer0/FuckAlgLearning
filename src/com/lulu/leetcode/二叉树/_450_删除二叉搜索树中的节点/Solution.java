package com.lulu.leetcode.二叉树._450_删除二叉搜索树中的节点;

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
    //HD Del
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (key < root.val) {
            root.left =  deleteNode(root.left, key);
            return root;
        }
        //找到这个节点了
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        //获取它的后继
        TreeNode successor = getMin(root.right);
        successor.right = removeMin(root.right);
        successor.left = root.left;
        return successor;
    }
    //获取获取最小节点
    private TreeNode getMin(TreeNode root) {
        if (root == null) return null;
        if (root.left == null) {
            return root;
        }
        return getMin(root.left);
    }
    //删除最小节点
    private TreeNode removeMin(TreeNode root) {
        if (root == null) return null;
        if (root.left == null) {
            return root.right;
        }
        root.left = removeMin(root.left);
        return root;
    }
}