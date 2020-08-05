package com.lulu.leetcode.链表._206_反转链表


/**
 * 模板类
 */
class Solution {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Solution()
        }
    }



    /**
     * Swaps x[a] with x[b].
     */
    private fun swap(x: IntArray, a: Int, b: Int) {
        val t = x[a]
        x[a] = x[b]
        x[b] = t
    }

}
