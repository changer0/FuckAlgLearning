package com.lulu.leetcode.链表._24_两两交换链表中的节点;

import com.lulu.leetcode.链表.java.ListNode;

/**
 *https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class Solution {
    public static void main(String[] args) {

    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;

        while(p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;

            p = node1;
        }
        return dummyHead.next;
    }
}
