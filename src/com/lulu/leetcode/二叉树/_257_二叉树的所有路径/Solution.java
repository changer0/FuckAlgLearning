package com.lulu.leetcode.二叉树._257_二叉树的所有路径;

import com.lulu.leetcode.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }


 给定一个二叉树，返回所有从根节点到叶子节点的路径。

 输入:

 1
 /   \
 2     3
 \
 5

 输出: ["1->2->5", "1->3"]

 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if (root == null) return ret;
        if (root.left == null && root.right == null) {
            ret.add(String.valueOf(root.val));
            return ret;
        }
        List<String> leftS = binaryTreePaths(root.left);
        for (int i = 0; i < leftS.size(); i++) {
            ret.add(root.val + "->" + leftS.get(i));
        }
        List<String> rightS = binaryTreePaths(root.right);
        for (int i = 0; i < rightS.size(); i++) {
            ret.add(root.val + "->" + rightS.get(i));
        }
        return ret;
    }
}