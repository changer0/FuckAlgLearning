package com.lulu.leetcode.链表._203_移除链表元素;

import com.lulu.leetcode.链表.java.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode listNode = ListNode.createLinkedList(new int[]{1, 1, 2, 3, 3});
        ListNode.printLinedList(listNode);
        ListNode.printLinedList(new Solution().removeElements(listNode, 1));

    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode curNode = dummyNode;
        while (curNode.next != null) {
            if (curNode.next.val == val) {
                ListNode delNode = curNode.next;
                curNode.next = delNode.next;
                delNode.next = null;
            } else {
                curNode = curNode.next;
            }
        }
        return dummyNode.next;
    }
}
