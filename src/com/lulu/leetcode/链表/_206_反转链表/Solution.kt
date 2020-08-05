package com.lulu.leetcode.链表._206_反转链表

import com.lulu.leetcode.链表.ListNode


/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
class Solution {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Solution()
        }
    }

    /**
     *  1->2->3->4->5->NULL
     *  5->4->3->2->1->NULL
     */
    fun reverseList(head: ListNode?): ListNode? {
        var pre: ListNode? = null
        var cur = head
        while (cur != null) {
            val next = cur.next
            cur.next = pre
            pre = cur
            cur = next
        }
        return pre
    }
}
