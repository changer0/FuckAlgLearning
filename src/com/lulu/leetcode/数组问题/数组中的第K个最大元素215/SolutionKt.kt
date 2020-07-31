package com.lulu.leetcode.数组问题.数组中的第K个最大元素215

import java.util.*


/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = intArrayOf(4, 2, 6, 5, 1, 2, 3)
            println(SolutionKt().findKthLargest(nums, 4))
            println(Arrays.toString(nums))

            println("quick sort：")
            println(SolutionKt().quickSort(nums))
            println(Arrays.toString(nums))
        }
    }

    /**
     * 快速排序思路
     */
    fun findKthLargest(nums: IntArray, k: Int): Int {
        findKthLargest(nums, k, 0, nums.size-1)
        return nums[nums.size-k]
    }

    fun findKthLargest(nums: IntArray, k: Int, l: Int, r: Int) {

        if (l >= r) {
            return
        }

        val p = partition2(nums, l, r)
        if (p >= nums.size - k) {
            findKthLargest(nums, k, l, p-1)
        } else {
            findKthLargest(nums, k, p+1, r)
        }
    }


    /**
     * 用来获取元素中间所在位置 [l, r]
     * cp: 检查点 用来表示需要跳过的位置
     */
    private fun partition2(nums: IntArray, l: Int, r: Int): Int {
        var p = l
        for (i in l+1 .. r) {
            if (nums[i] < nums[l]) {
                swap(nums, i, ++p)
            }
        }
        swap(nums, l, p)
        return p
    }


    /**
     * Swaps x[a] with x[b].
     */
    private fun swap(x: IntArray, a: Int, b: Int) {
        val t = x[a]
        x[a] = x[b]
        x[b] = t
    }



    //------------------------------------------------------------------------------------------------------------------
    //快速排序 start

    fun quickSort(nums: IntArray) {
        quickSort(nums, 0, nums.size-1)

    }

    private fun quickSort(nums: IntArray, l: Int, r: Int) {
        if (l >= r) {
            return
        }
        val p = partition(nums, l, r)
        quickSort(nums, l, p-1)
        quickSort(nums, p+1, r)
    }

    /**
     * 用来获取元素中间所在位置 [l, r]
     */
    private fun partition(nums: IntArray, l: Int, r: Int): Int {
        var p = l // 目标位置
        for (i in l+1 .. r) {
            if (nums[i] < nums[l]) {
                swap(nums, i, ++p)
            }
        }
        swap(nums, l, p)
        return p
    }

    //快速排序 end
    //------------------------------------------------------------------------------------------------------------------

}
