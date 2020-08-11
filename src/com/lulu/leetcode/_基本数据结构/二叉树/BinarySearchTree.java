package com.lulu.leetcode._基本数据结构.二叉树;

import java.util.LinkedList;
import java.util.Queue;

//二分搜索树
class BinarySearchTree {
    static class Node {
        int key;
        int value;
        Node left;
        Node right;
        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int count = 0;//节点个数
    private Node root;//根节点
    public BinarySearchTree() {
        count = 0;
        root = null;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    //插入一个节点，返回插入的跟节点
    public Node insert(int key, int value) {
        root = insert(root, key, value);
        return root;
    }
    private Node insert(Node root, int key, int value) {
        if (root == null) {
            root = new Node(key, value);
            count++;
            return root;
        }
        if (key < root.key) {
            root.left = insert(root.left, key, value);
        } else if (key > root.key) {
            root.right = insert(root.right, key, value);
        } else {
            root.value = value;
        }
        return root;
    }

    // 前序遍历打印
    public void prePrint() {
        prePrint(root);
    }
    public void prePrint(Node root) {
        if (root == null ) return;
        System.out.print(root.key + " ");
        prePrint(root.left);
        prePrint(root.right);
    }

    public void print() {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node == null) {
                System.out.print("null ");
            } else {
                System.out.print(node.key + " ");
                q.offer(node.left);
                q.offer(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(28, 1);
        tree.insert(16, 2);
        tree.insert(30, 6);
        tree.insert(13, 7);
        tree.insert(22, 7);
        tree.insert(29, 7);
        tree.insert(42, 7);
        tree.insert(23, 7);
        tree.insert(14, 7);
        tree.insert(12, 7);
        tree.insert(20, 7);

//        tree.insert(4, 1);
//        tree.insert(5, 2);
//        tree.insert(6, 6);
//        tree.insert(8, 7);
//        tree.insert(9, 7);
//        tree.insert(10, 7);
//        tree.insert(12, 7);
        tree.print();
        //System.out.println(tree.size());
    }
}
