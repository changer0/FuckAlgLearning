package com.lulu.leetcode.合并两个有序数组88

import java.util.*


/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 归并
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
            val nums2 = intArrayOf(2, 5, 6)
            SolutionKt().merge3(nums1, 3, nums2, 3)
            println(Arrays.toString(nums1))
        }
    }

    /**
     * 一种 low 实现方案 需要多创建一个数组
     */
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = 0
        var j = 0
        var index = 0
        val nums = IntArray(m+n)
        while (index < m+n) {

            if (i >= m && j < nums2.size) {
                nums[index] = nums2[j++]
                index++
                continue
            }
            if (j >= n && i < nums1.size) {
                nums[index] = nums1[i++]
                index++
                continue
            }
            if (nums1[i] > nums2[j]) {
                nums[index] = nums2[j++]
            } else {
                nums[index] = nums1[i++]
            }
            index++
        }
        for (i in 0 until nums.size) {
            nums1[i] = nums[i]
        }
    }

    /**
        输入:
        nums1 = [1,2,3,0,0,0], m = 3
        nums2 = [2,5,6],       n = 3

        输出: [1,2,2,3,5,6]

        倒序方式
     */
    fun merge2(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var k = m+n-1 //表示需要换入的 index
        var i = m-1; var j = n-1
        while (k >= 0) {

            if (i < 0 && j >= 0) {
                nums1[k] = nums2[j--]
                k--
                continue
            }
            if(j < 0 && i >= 0) {
                nums1[k] = nums1[i--]
                k--
                continue
            }
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i--]
            } else {
                nums1[k] = nums2[j--]
            }
            k--
        }
    }

    /**
     * 优化版
     */
    fun merge3(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var k = m+n-1 //表示需要换入的 index
        var i = m-1; var j = n-1
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--]
            } else {
                nums1[k--] = nums2[j--]
            }
        }
        //如果 nums1 中的值普遍小，需要把 nums2 中的前面剩下的内容 copy 到 nums1 中
        System.arraycopy(nums2, 0, nums1, 0, j + 1)
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
