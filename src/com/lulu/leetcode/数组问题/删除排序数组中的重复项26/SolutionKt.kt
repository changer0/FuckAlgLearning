package com.lulu.leetcode.数组问题.删除排序数组中的重复项26

import java.util.*

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = intArrayOf(1, 1, 1, 2, 2, 4)
            println(SolutionKt().removeDuplicates(nums))
            println(Arrays.toString(nums))
        }
    }

    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        if (nums.size <= 1) {
            return 1
        }
        var k = 1//当前需要交换的 index
        for (i in 1 until nums.size) {
            if (nums[i] != nums[k-1]) {
                if (k != i) {
                    nums[k++] = nums[i]
                } else {
                    k++
                }

            }
        }
        return k
    }

}
