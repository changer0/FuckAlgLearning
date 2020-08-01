package com.lulu.leetcode.数组问题.长度最小的子数组209

import java.util.*


/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，
 * 找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = intArrayOf(2,3,1,2,4,3)
            println(SolutionKt().minSubArrayLen(7, nums))
        }
    }


    /**
     * 双指针索引：滑块窗口
     */
    fun minSubArrayLen(s: Int, nums: IntArray): Int {
        var l = 0; var r = -1 //定义滑块的左右指针：[l, r]
        var sum = 0 //连续子数组的和
        var minLength = nums.size + 1 //定义最短子数组的长度

        while (l < nums.size) {
            if (r+1 < nums.size && sum < s) {//如果小，滑块右侧向右移动
                sum += nums[++r]
            } else {//否则滑块左侧向右移动
                sum -= nums[l++]
            }

            if (sum >= s) {//不放到上面的 else 中是由于 r+1 这个判断会导致有误
                minLength = Math.min(minLength, r-l+1)
            }
        }

        if (minLength == nums.size + 1) {
            return 0
        }

        return minLength
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
