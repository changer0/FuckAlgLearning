package com.lulu.leetcode.数组中的第K个最大元素215

import java.util.*


/**
 * 模板类
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = intArrayOf(4, 2, 6, 5, 1, 2, 3)
            println(SolutionKt().findKthLargest(nums, 4))
            println(Arrays.toString(nums))
        }
    }

    /**
     * 快速排序思路
     */
    fun findKthLargest(nums: IntArray, k: Int): Int {
        var p = 0
        var isFinish = true
        for (i in 1 until nums.size) {
            if (nums[i] > nums[p]) {

                for (j in i+1 until nums.size) {
                    if (nums[j] < nums[p]) {
                        swap(nums, j, i)
                        break
                    }
                }

            }
        }

        return 0
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
