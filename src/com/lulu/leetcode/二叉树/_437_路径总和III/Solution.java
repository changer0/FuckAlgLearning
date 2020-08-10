package com.lulu.leetcode.二叉树._437_路径总和III;

/**
 *
 */

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

 给定一个二叉树，它的每个结点都存放着一个整数值。

 找出路径和等于给定数值的路径总数。

 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。


 root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

 10
 /  \
 5   -3
 / \    \
 3   2   11
 / \   \
 3  -2   1

 返回 3。和等于 8 的路径有:

 1.  5 -> 3
 2.  5 -> 2 -> 1
 3.  -3 -> 11

 */
class Solution {
    //从所有节点中找符合 sum 的路径个数
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = findPath(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }
    //找到当前节点符合 sum 路径的个数
    private int findPath(TreeNode root, int num) {
        if (root == null) return 0;
        int res = 0;
        if (num - root.val == 0) {
            res += 1;
        }
        res += findPath(root.left, num-root.val);
        res += findPath(root.right, num-root.val);
        return res;
    }
}