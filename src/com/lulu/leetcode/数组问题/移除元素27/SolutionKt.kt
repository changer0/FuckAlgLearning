package com.lulu.leetcode.数组问题.移除元素27

import java.util.*


/**
 * https://leetcode-cn.com/problems/remove-element/
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = intArrayOf(3,2,2,3)
            println(SolutionKt().removeElement(nums, 3))
            println(Arrays.toString(nums))
        }
    }

    fun removeElement(nums: IntArray, v: Int): Int {
        var k = 0 //记录交换位置
        for (i in 0 until nums.size) {
            if (nums[i] != v)
                if (k != i) {
                    nums[k++] = nums[i]
                } else {
                    k++
                }
        }
        return k
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
