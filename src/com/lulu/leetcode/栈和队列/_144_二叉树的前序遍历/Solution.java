package com.lulu.leetcode.栈和队列._144_二叉树的前序遍历;

import com.lulu.leetcode.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class Solution {
    public static void main(String[] args) {

    }


    //使用栈的方式
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<Command> stack = new Stack<>();
        stack.push(new Command(1, root));
        while(!stack.isEmpty()) {
            Command com = stack.pop();
            if(com.command == 0) {
                res.add(com.node.val);
            } else {
                assert(com.command == 1);
                if(com.node.right != null) {
                    stack.push(new Command(1, com.node.right));
                }
                if(com.node.left != null) {
                    stack.push(new Command(1, com.node.left));
                }
                stack.push(new Command(0, com.node));
            }
        }
        return res;
    }

    static class Command {
        int command = 0;//0 表示执行，1 表示打印
        TreeNode node;
        public Command(int command, TreeNode node) {
            this.command = command;
            this.node = node;
        }
    }

    //递归办法 非题目进阶要求
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        preorderTraversal(root, res);

        return res;
    }

    private void preorderTraversal(TreeNode root, List<Integer> res) {
        if(root != null) {
            res.add(root.val);
            preorderTraversal(root.left, res);
            preorderTraversal(root.right, res);
        }
    }
}
