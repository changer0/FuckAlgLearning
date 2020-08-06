package com.lulu.leetcode.链表.java;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }


    public static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode curNode = head;
        for (int i = 0; i < arr.length; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
        return head;
    }

    public static void printLinedList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }

        ListNode curNode = head;
        while (curNode != null) {
            System.out.print(curNode.val + "->");
            curNode = curNode.next;
        }
        System.out.println("null");
    }
}
