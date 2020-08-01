package com.lulu.leetcode.数组问题._167_两数之和

import java.util.*


/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = intArrayOf(2, 7, 11, 15)
            println(Arrays.toString(SolutionKt().twoSum2(nums, 9)))
        }
    }

    /**
     * 二分查找法 low
     */
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        for (i in 0 until numbers.size-1) {
            val binarySearch = binarySearch(numbers, target - numbers[i], i + 1, numbers.size - 1)
            if (binarySearch != -1) {
                return intArrayOf(i+1, binarySearch+1)
            }
        }
        return intArrayOf()
    }

    /**
     * 二分查找
     */
    fun binarySearch(nums: IntArray, t: Int, s: Int, e: Int): Int {
        var l = s; var r = e
        while (l <= r ) {
            val mid = (l+r)/2
            if (nums[mid] == t) {
                return mid
            }
            if (t < nums[mid]) {
                r = mid-1
            } else {
                l = mid+1
            }
        }
        return -1
    }

    /**
     *  对撞指针 推荐 O(n)
     */
    fun twoSum2(numbers: IntArray, target: Int): IntArray {
        var l = 0; var r = numbers.size - 1

        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                return intArrayOf(l+1, r+1)
            }
            if (numbers[l] + numbers[r] < target) {
                l++
            } else {
                r--
            }
        }
        return intArrayOf()
    }


}
