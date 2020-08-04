package com.lulu.leetcode.查找表问题._16_最接近的三数之和

import java.util.*
import kotlin.math.abs
import kotlin.math.min


/**
 * https://leetcode-cn.com/problems/3sum-closest/
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(SolutionKt().threeSumClosest(intArrayOf(-1, 2, 1, -4), 1))
        }
    }

    /**
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     */
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var min = 10 * 10 * 10
        var result = target
        //val arr = IntArray(3)
        nums.sort()
        for (k in 0 until nums.size-2) {
            if (k != 0 && nums[k] == nums[k-1]) continue
            var l = k + 1; var r = nums.size-1
            while (l < r) {
                val complement = nums[k] + nums[l] + nums[r]
                var abs = Math.abs(complement - target)
                if (abs < min) {
                    result = complement
                    min = abs
//                    arr[0] = k
//                    arr[1] = l
//                    arr[2] = r
                }
                if (complement < target) {
                    while (l < r && nums[l] == nums[++l]);
                } else if (complement > target) {
                    while (l < r && nums[r] == nums[--r]);
                } else {
                    return complement
                }
            }

        }
        //println(arr.contentToString())
        return result
    }

}
