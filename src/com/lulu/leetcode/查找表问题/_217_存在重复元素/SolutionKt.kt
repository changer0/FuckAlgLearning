package com.lulu.leetcode.查找表问题._217_存在重复元素


/**
 * https://leetcode-cn.com/problems/contains-duplicate-ii
 *
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(SolutionKt().containsDuplicate(intArrayOf(1, 2, 3, 1)))
            println(SolutionKt().containsDuplicate(intArrayOf(1,2,3,4)))
        }
    }

    /**
     * [1,2,3,1] true
     * 时间复杂度：O(n) ？？
     */
    fun containsDuplicate(nums: IntArray): Boolean {
        val record = hashSetOf<Int>()
        for (i in 0 until nums.size) {
            if (record.contains(nums[i])) {
                return true
            }
            record.add(nums[i])
        }
        return false
    }

}
