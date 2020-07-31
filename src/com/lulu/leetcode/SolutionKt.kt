package com.lulu.leetcode


/**
 * 模板类
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SolutionKt()
        }
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
