package com.lulu.leetcode.数组问题.盛最多水的容器11


/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(SolutionKt().maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
        }
    }

    /**
     * 对撞指针求解
     */
    fun maxArea(nums: IntArray): Int {
        var max = -1
        var l = 0; var r = nums.size-1
        while (l < r) {
            var t = -1
            if (nums[l] > nums[r]) {
                t = (r - l) * nums[r--]
            } else {
                t = (r - l) * nums[l++]
            }
            if (t > max) {
                max = t
            }
        }
        return max
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
