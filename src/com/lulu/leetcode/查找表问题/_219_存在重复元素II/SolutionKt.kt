package com.lulu.leetcode.查找表问题._219_存在重复元素II


/**
 * https://leetcode-cn.com/problems/contains-duplicate-ii
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(SolutionKt().containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 3))
            println(SolutionKt().containsNearbyDuplicate(intArrayOf(1,2,3,1,2,3), 2))
        }
    }

    /**
     * 滑动窗口 + 查找表
     */
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val record = hashSetOf<Int>() //保存当前值
        for (i in 0 until nums.size) {
            if (record.contains(nums[i])) {
                return true
            }
            record.add(nums[i])
            if (record.size == k + 1) {
                record.remove(nums[i - k])
            }
        }
        return false
    }

}
