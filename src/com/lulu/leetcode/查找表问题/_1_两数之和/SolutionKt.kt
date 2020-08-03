package com.lulu.leetcode.查找表问题._1_两数之和

import java.lang.RuntimeException
import java.util.*


/**
 * https://leetcode-cn.com/problems/two-sum/
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arr = SolutionKt().twoSum(intArrayOf(2, 7, 11, 15), 9)
            println(Arrays.toString(arr))
        }
    }

    /**
     * 利用查找表
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        //记录 nums 中 值 和 索引值
        val record = hashMapOf<Int, Int>()
        for (i in 0 until nums.size) {
            val temp = target - nums[i]
            val ti = record[temp]//查看之前的查找表中是否有值，如果发现有，这说明相加 = target
            if (ti != null) {
                return intArrayOf(ti, i)
            }
            //保存 索引值
            record[nums[i]] = i
        }
        throw IllegalArgumentException("no found target")
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
