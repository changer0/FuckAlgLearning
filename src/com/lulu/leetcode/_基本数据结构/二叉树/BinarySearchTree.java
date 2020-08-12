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
    public Node getMax() {
        return getMax(root);
    }
    private Node getMax(Node root) {
        if (root == null) return null;
        if (root.right == null) return root;
        return getMax(root.right);
    }
    //获取最小值
    public Node getMin() {
        return getMin(root);
    }
    private Node getMin(Node root) {
        if (root == null) return null;
        if (root.left == null) return root;
        return getMin(root.left);
    }
    //删除最大节点
    public void removeMax() {
         root = removeMax(root);
    }
    //这个返回值表示返回的左子树
    private Node removeMax(Node root) {
        if (root == null) return null;
        if (root.right == null) {
            count--;
            return root.left;
        }
        root.right = removeMax(root.right);
        return root;
    }
    //删除最小节点
    public void removeMin() {
        root = removeMin(root);
    }
    private Node removeMin(Node root) {
        if (root == null) return null;
        if (root.left == null) {
            count--;
            return root.right;
        }
        root.left = removeMin(root.left);
        return root;
    }
    //根据任意 key 值来删除
    public void removeByKey(int key) {
        root = removeByKey(root, key);
    }

    private Node removeByKey(Node root, int key) {
        if (root == null) return null;
        if (key > root.key) { //需要删除的值在右边
            root.right = removeByKey(root.right, key);
            return root;
        }
        if (key < root.key) { //需要删除的值在左边
            root.left = removeByKey(root.left, key);
            return root;
        }
        //此时说明已经找到了该节点
        if (root.right == null) {
            count--;
            return root.left;
        }
        if (root.left == null) {
            count--;
            return root.right;
        }
        //此时说明左右节点均不为空
        //取出右节点最小值，即要删除掉的节点的后继
        Node rightMin = getMin(root.right);
        Node successor = new Node(rightMin.key, rightMin.value);
        successor.left = rightMin.left;
        successor.right = rightMin.right;
        count++;//注意维护 count
        successor.right = removeMin(root.right);
        successor.left = root.left;
        count--;
        return successor;
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
//        tree.insert(23, 9999);
//        tree.insert(14, 99999);
//        tree.insert(12, 888);
//        tree.insert(20, 88);

        tree.print();
//        System.out.println(tree.contain(12));
//        System.out.println(tree.contain(99));
//        System.out.println(tree.getValue(12));
//        System.out.println(tree.getValue(30));
//        System.out.println(tree.getValue(90));
//        System.out.println("最大值：" + tree.getMax().key);
//        System.out.println("最小值：" + tree.getMin().key);
//        System.out.println("删除最小值：" );
//        tree.removeMin();
//        tree.print();
//        System.out.println("删除最大值：");
//        tree.removeMax();
//        tree.print();
        //System.out.println(tree.size());


        System.out.println("删掉 30 节点：");
        tree.removeByKey(30);
        tree.print();
    }
    
}
