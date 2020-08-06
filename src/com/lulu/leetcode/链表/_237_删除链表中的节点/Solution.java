package com.lulu.leetcode.链表._237_删除链表中的节点;

import com.lulu.leetcode.链表.java.ListNode;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class Solution {
    public static void main(String[] args) {

    }

    //赋值一次，删掉后面的节点
    public void deleteNode(ListNode node) {
        if(node == null) {
            return;
        }
        if(node.next == null) {
            node = null;
            return;
        }
        node.val = node.next.val;
        ListNode delNode = node.next;
        node.next = delNode.next;
        delNode.next = null;
    }
    //移动所有的值，不推荐
    public void deleteNode1(ListNode node) {
        ListNode pre = null;
        while(node.next != null) {
            pre = node;
            node.val = node.next.val;
            node = node.next;
        }
        pre.next = null;
        node = null;
    }
}
