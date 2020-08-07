package com.lulu.leetcode.链表._19_删除链表的倒数第N个节点;

import com.lulu.leetcode.链表.java.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class Solution {
    public static void main(String[] args) {

    }
    // 双索引技术
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;//标记删除位置
        ListNode q = dummyHead;//标记最后的位置
        //p q 之间的距离是一定的，先将 q 的位置移动到 n+1 次
        for(int i = 0; i < n+1; i++) {
            q = q.next;
        }
        //当 q 为空时，p.next 就是删除位
        while(q != null) {
            p = p.next;
            q = q.next;
        }
        ListNode delNode = p.next;
        p.next = delNode.next;
        delNode.next = null;
        return dummyHead.next;
    }
}
