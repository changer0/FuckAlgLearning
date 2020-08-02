package com.lulu.leetcode.查找表问题._349_两个数组的交集

import java.util.*


/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = SolutionKt().intersection(intArrayOf(1,2,2,1), intArrayOf(2, 2))
            println(Arrays.toString(result))
        }
    }


    /**
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * e输出：[9,4]
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2]
     */
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val record = HashSet<Int>(nums1.toMutableList())
        val result = HashSet<Int>()
        for (num in nums2) {
            if (record.contains(num)) {
                result.add(num)
            }
        }
        return result.toIntArray()
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
