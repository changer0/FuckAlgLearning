package com.lulu.leetcode.查找表问题._220_存在重复元素III


import java.util.*


/**
 * https://leetcode-cn.com/problems/contains-duplicate-iii/
 *
 * 在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t，且满足 i 和 j 的差的绝对值也小于等于 ķ 。
 * 如果存在则返回 true，不存在返回 false。
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(SolutionKt().containsNearbyAlmostDuplicate(intArrayOf(1, 2, 3, 1), 3, 0))
            println(SolutionKt().containsNearbyAlmostDuplicate(intArrayOf(1, 5, 9, 1, 5, 9), 2, 3))
            println(SolutionKt().containsNearbyAlmostDuplicate(intArrayOf(2,1), 1, 1))
        }
    }

    /**
     * nums = [1,2,3,1], k = 3, t = 0 true
     * nums = [1,5,9,1,5,9], k = 2, t = 3 false
     *
     */
    fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
        val record = TreeSet<Long>() //保存当前值
        for (i in 0 until nums.size) {
            val l = record.ceiling(nums[i].toLong() - t.toLong())
            if (l != null && l <= nums[i] + t)
                return true
            val r = record.floor(nums[i].toLong() + t.toLong())
            if (r != null && r >= nums[i].toLong() - t.toLong())
                return true
            record.add(nums[i].toLong())
            if (record.size == k + 1) {
                record.remove(nums[i - k].toLong())
            }
        }
        return false
    }

}
