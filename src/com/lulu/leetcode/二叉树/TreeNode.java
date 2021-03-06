package com.lulu.leetcode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int x) {
        val = x;
    }

    public static void main(String[] args) {

        TreeNode node1 = createTree(new int[]{4, 2, 7, 1, 3, 6, 9});
        TreeNode node2 = createTree(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
        print(node1);
        printWithStructure(node2);
    }

    public static TreeNode createTree(int[] data) {
        TreeNode[] nodes = new TreeNode[data.length];
        //每个节点赋值
        for (int i = 0; i < data.length; i++) {
            nodes[i] = new TreeNode(data[i]);
        }
        int i = 0;
        while (i < nodes.length) {
            int parentIndex = (i-1)/2;
            if (parentIndex < 0) {
                i ++;
                continue;
            }
            int leftChild = 2*parentIndex + 1;
            if (leftChild < nodes.length) {
                nodes[parentIndex].left = nodes[leftChild];
            } else {
                nodes[parentIndex].left = null;
            }
            int rightChild = 2*parentIndex + 2;
            if (rightChild < nodes.length) {
                nodes[parentIndex].right = nodes[rightChild];
            } else {
                nodes[parentIndex].right = null;
            }

            i++;
        }
        return nodes[0];
    }

//    public static void print(TreeNode root) {
//        if(root == null) {
//            return;
//        }
//
//        System.out.print(root.val + " ");
//        print(root.left);
//        print(root.right);
//    }

    public static void print(TreeNode root) {
        if(root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.val + " ");
            if(node.left != null) {
                q.offer(node.left);
            }
            if(node.right != null) {
                q.offer(node.right);
            }
        }
        System.out.println();
    }

    /**
     * 带结构的打印
     * @param root
     */
    public static void printWithStructure(TreeNode root) {
        if(root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> treeArr = new ArrayList<>();
        int level = 0;//层数
        while(!q.isEmpty()) {
            List<Integer> levelArr = new ArrayList<>();
            treeArr.add(levelArr);
            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();
                System.out.print(node.val + " ");
                levelArr.add(node.val);
                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
            System.out.println();
            level++;
        }
        System.out.println();
        System.out.println(level);
    }
}