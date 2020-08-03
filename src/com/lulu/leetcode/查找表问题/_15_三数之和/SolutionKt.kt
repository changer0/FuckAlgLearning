package com.lulu.leetcode.查找表问题._15_三数之和


/**
 * https://leetcode-cn.com/problems/3sum/
 *
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组

 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SolutionKt()
        }
    }

    /**
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
    。* [-1, -1, 2]
     * ]
     */
    fun threeSum(nums: IntArray): List<List<Int>> {
        val arr = ArrayList<ArrayList<Int>>()
        return arr
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
