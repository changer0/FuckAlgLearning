package com.lulu.leetcode.查找表问题._454_四数相加II


/**
 * https://leetcode-cn.com/problems/4sum-ii/
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                SolutionKt().fourSumCount(
                    intArrayOf(1, 2),
                    intArrayOf(-2, -1),
                    intArrayOf(-1, 2),
                    intArrayOf(0, 2)
                )
            )
        }
    }

    /**
     * A = [ 1, 2]
     * B = [-2,-1]
     * C = [-1, 2]
     * D = [ 0, 2]
     * A[i] + B[j] + C[k] + D[l] = 0
     * 多少个四元组：2
     */
    fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
        var res = 0
        val record = hashMapOf<Int, Int>() // C+D 作为 key 出现频率作为 value
        for (c in C) {
            for (d in D) {
                val complement = c + d
                record[complement] = record.getOrDefault(complement, 0) + 1
            }
        }
        for (a in A) {
            for (b in B) {
                val complement = 0 - a - b
                if (record.containsKey(complement)) {
                    res += record.getOrDefault(complement, 0)
                }
            }
        }
        return res
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
