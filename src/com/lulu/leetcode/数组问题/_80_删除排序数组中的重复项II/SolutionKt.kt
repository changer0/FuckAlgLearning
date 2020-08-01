package com.lulu.leetcode.数组问题._80_删除排序数组中的重复项II

import java.util.*


/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = intArrayOf(1, 1, 1, 1, 2, 2, 3, 4)
            println(SolutionKt().removeDuplicates(nums))
            println(Arrays.toString(nums))
        }
    }

    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size <= 2) {
            return nums.size
        }
        var k = 1
        for (i in 2 until nums.size) {
            if (nums[i] != nums[k] || nums[i] != nums[k-1]) {
                nums[++k] = nums[i]
            }
        }
        return k+1
    }

}
