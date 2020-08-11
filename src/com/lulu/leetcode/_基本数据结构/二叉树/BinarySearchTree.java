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
    //判断是否包含当前 key
    public boolean contain(int key) {
        if (isEmpty()) return false;
        return contain(root, key);
    }

    private boolean contain(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (key < root.key) {
            return contain(root.left, key);
        } else if (key > root.key) {
            return contain(root.right, key);
        } else {
            return true;
        }
    }
    //获取 key 对应的 value
    public int getValue(int key) {
        return getValue(root, key);
    }

    private int getValue(Node root, int key) {
        if (root == null) return -1;
        if (key < root.key) {
            return getValue(root.left, key);
        } else if (key > root.key) {
            return getValue(root.right, key);
        } else {
            return root.value;
        }
    }
    //获取最大值
    public int getMaxValue() {
        return getMaxValue(root);
    }
    private int getMaxValue(Node root) {
        if (root == null) return -1;
        if (root.right == null) return root.value;
        return getMaxValue(root.right);
    }
    //获取最小值
    public int getMinValue() {
        return getMinValue(root);
    }
    private int getMinValue(Node root) {
        if (root == null) return -1;
        if (root.left == null) return root.value;
        return getMinValue(root.left);
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
    //层序遍历
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
        System.out.println();
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(28, 1);
        tree.insert(16, 2);
        tree.insert(30, 6);
        tree.insert(13, 7);
        tree.insert(22, 9);
        tree.insert(29, 99);
        tree.insert(42, 999);
        tree.insert(23, 9999);
        tree.insert(14, 99999);
        tree.insert(12, 888);
        tree.insert(20, 88);

//        tree.insert(4, 1);
//        tree.insert(5, 2);
//        tree.insert(6, 6);
//        tree.insert(8, 7);
//        tree.insert(9, 7);
//        tree.insert(10, 7);
//        tree.insert(12, 7);
        tree.print();
        System.out.println(tree.contain(12));
        System.out.println(tree.contain(99));
        System.out.println(tree.getValue(12));
        System.out.println(tree.getValue(30));
        System.out.println(tree.getValue(90));
        System.out.println("最大值：" + tree.getMaxValue());
        System.out.println("最小值：" + tree.getMinValue());
        //System.out.println(tree.size());
    }
}
