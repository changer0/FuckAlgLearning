package com.lulu.leetcode.链表._21_合并两个有序链表;

import com.lulu.leetcode.链表.java.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class Solution {
    public static void main(String[] args) {
        ListNode listNode1 = ListNode.createLinkedList(new int[]{1, 2, 4});
        ListNode listNode2 = ListNode.createLinkedList(new int[]{1, 3, 4});
        ListNode.printLinedList(new Solution().mergeTwoLists(listNode1, listNode2));
    }

    /**
     * 1->2->4, 1->3->4
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode l1Cur = dummy;
        ListNode l2Cur = l2;
        while( l1Cur.next != null && l2Cur != null) {
            if(l1Cur.next.val > l2Cur.val) {
                ListNode endNode = l1Cur.next;
                ListNode iNode = new ListNode(l2Cur.val);
                l1Cur.next = iNode;
                iNode.next = endNode;
                l1Cur = iNode;//需要指向插入的值
                l2Cur = l2Cur.next;
            } else {
                l1Cur = l1Cur.next;
            }
        }
        while(l2Cur != null) {
            ListNode newNode = new ListNode(l2Cur.val);
            l1Cur.next = newNode;
            l1Cur = newNode;
            l2Cur = l2Cur.next;
        }
        return dummy.next;
    }
}
