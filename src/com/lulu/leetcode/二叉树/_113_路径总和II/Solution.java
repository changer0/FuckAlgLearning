package com.lulu.leetcode.二叉树._113_路径总和II;

import com.lulu.leetcode.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> lists = new Solution().pathSum(root, 22);

        System.out.println(lists.toString());

    }

    /**
     *
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Stack<Integer>> path = checkPath(root, sum);
        for (int i = 0; i < path.size(); i++) {
            Stack<Integer> stack = path.get(i);
            List<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
            ret.add(list);
        }
        return ret;
    }

    private List<Stack<Integer>> checkPath(TreeNode root, int sum) {
        List<Stack<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        if (root.left == null && root.right == null && sum - root.val == 0) {
            Stack<Integer> k = new Stack();
            k.push(root.val);
            ret.add(k);
            return ret;
        }
        List<Stack<Integer>> leftL = checkPath(root.left, sum - root.val);
        for (int i = 0; i < leftL.size(); i++) {
            leftL.get(i).push(root.val);
        }
        List<Stack<Integer>> rightL = checkPath(root.right, sum - root.val);
        for (int i = 0; i < rightL.size(); i++) {
            rightL.get(i).push(root.val);
        }
        ret.addAll(leftL);
        ret.addAll(rightL);
        return ret;
    }
}
