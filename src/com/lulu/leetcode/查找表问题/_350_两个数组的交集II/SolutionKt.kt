package com.lulu.leetcode.查找表问题._350_两个数组的交集II

import java.util.*


/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("测试 Map - start")
            SolutionKt().testMap()
            println("测试 Map - end")


            val res = SolutionKt().intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2))
            println(Arrays.toString(res))
            val res1 = SolutionKt().intersect(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4))
            println(Arrays.toString(res1))
        }
    }

    /**
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     */
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val record = hashMapOf<Int, Int>()
        for (num in nums1) {
            record[num] = record.getOrDefault(num, 0) + 1
        }
        val result = mutableListOf<Int>()
        for (num in nums2) {
            val re = record.getOrDefault(num, 0)
            if (re > 0) {
                result.add(num)
                if (re - 1 <= 0) {
                    record.remove(num)
                } else {
                    record[num] = re-1
                }
            }
        }

        return result.toIntArray()
    }


    //------------------------------------------------------------------------------------------------------------------
    // 测试 Map start

    fun testMap() {
        val map = mutableMapOf<Int, Int>()
        println(map.containsKey(10))
        println(map[10])
        println(map.containsKey(10))
    }

}
