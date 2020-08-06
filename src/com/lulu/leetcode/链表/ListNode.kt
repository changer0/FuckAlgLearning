package com.lulu.leetcode.链表

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    companion object {
        public fun createLinkedList(arr: IntArray, n: Int): ListNode? {
            if (n == 0) {
                return null
            }
            val head: ListNode? = ListNode(arr[0])
            var curNode = head
            for (i in 1 until n) {
                curNode?.next = ListNode(arr[i])
                curNode = curNode?.next
            }
            return head
        }

        public fun printLinedList(head: ListNode?) {
            if (head == null) {
                println("null")
                return
            }

            var curNode: ListNode? = head
            while (curNode != null) {
                print("${curNode.`val`}->")
                curNode = curNode.next
            }
            println("null")
        }

        @JvmStatic
        fun main(args: Array<String>) {
            val head = createLinkedList(intArrayOf(1, 2, 3, 4, 5, 6), 6)
            printLinedList(head)
        }
    }


}