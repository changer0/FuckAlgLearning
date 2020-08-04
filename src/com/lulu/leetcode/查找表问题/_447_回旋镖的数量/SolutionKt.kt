package com.lulu.leetcode.查找表问题._447_回旋镖的数量


/**
 * https://leetcode-cn.com/problems/number-of-boomerangs/
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arr = arrayOf(intArrayOf(0, 0), intArrayOf(1, 0), intArrayOf(2, 0))
            println(SolutionKt().numberOfBoomerangs(arr))
            val arr1 = arrayOf(intArrayOf(0, 0), intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(1, 1))
            println(SolutionKt().numberOfBoomerangs(arr1))
        }
    }
    /**
     * [[0,0],[1,0],[2,0]]
     * 2
     * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
     * 以某个点为中心，看到它距离的个数
     */
    fun numberOfBoomerangs(points: Array<IntArray>): Int {
        var res = 0

        for (i in 0 until points.size) {
            val record = hashMapOf<Int, Int>()//key: 距离 value: 个数
            for (j in 0 until points.size) {
                if (i == j) continue
                val dis = dis(points[i], points[j])
                record[dis] = record.getOrDefault(dis, 0) + 1
            }
            for (mutableEntry in record) {
                res += (mutableEntry.value * (mutableEntry.value-1))
            }
        }

        return res
    }

    /**
     * 为防止出现小数，直接不开根号
     */
    private fun dis(p1: IntArray, p2: IntArray): Int{
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0])
    }
}
