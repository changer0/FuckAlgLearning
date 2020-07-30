package com.lulu.leetcode.颜色分类75

import java.util.*


/**
 * https://leetcode-cn.com/problems/sort-colors/
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = intArrayOf(2,0,2,1,1,0)
            SolutionKt().sortColors(nums)
            println(Arrays.toString(nums))

            println("sort2:")
            val nums1 = intArrayOf(2,0,2,1,1,0)
            SolutionKt().sortColors2(nums1)
            println(Arrays.toString(nums1))
        }
    }

    /**
     * 采用三路排序
     */
    fun sortColors(nums: IntArray): Unit {
        var zero = -1
        var two = nums.size
        var i = 0
        while (i < two) {
            if (nums[i] == 1) {
                i++
            } else if (nums[i] == 2) {
                two--
                swap(nums, i, two)
            } else {
                assert(nums[i] == 0)
                zero++
                swap(nums, zero, i)
                i++
            }
        }
    }

    /**
     * 采用计数排序 非常适合这种
     */
    fun sortColors2(nums: IntArray): Unit {
        var count = IntArray(3){0} //用于存储频率
        for (i in 0 until nums.size) {
            count[nums[i]]++
        }
        var curIndex = 0
        for (i in 0 until count.size) {
            for (j in 0 until count[i]) {
                nums[curIndex++] = i
            }
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
