package com.lulu.leetcode.二叉树._108_将有序数组转换为二叉搜索树;

import com.lulu.leetcode.二叉树.TreeNode;

/**
 *
 */
public class Solution {
    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }
    private TreeNode sortedArrayToBST(int[] nums, int p, int q) {
        if (p > q) return null;
        int mid = (p + q)/2;//取中间值
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, p, mid-1);
        node.right = sortedArrayToBST(nums, mid+1, q);
        return node;
    }
}
