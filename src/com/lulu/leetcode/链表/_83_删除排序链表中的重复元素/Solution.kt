package com.lulu.leetcode.链表._83_删除排序链表中的重复元素

import com.lulu.leetcode.链表.ListNode


/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
class Solution {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val head = ListNode.createLinkedList(intArrayOf(1, 1, 2, 3, 3), 5)
            ListNode.printLinedList(head)
            ListNode.printLinedList(Solution().deleteDuplicates(head))
        }
    }

    /**
     * 记录
     */
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val record = hashSetOf<Int>()
        var curNode = head
        var preNode: ListNode? = null
        while (curNode != null) {
            if (record.contains(curNode.`val`)) {
                //存在重复，执行删除
                preNode?.next = curNode.next
                curNode.next = null
            } else {
                preNode = curNode
            }
            record.add(curNode.`val`)
            curNode = preNode?.next
        }

        return head
    }
}
