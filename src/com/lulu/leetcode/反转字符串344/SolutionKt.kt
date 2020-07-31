package com.lulu.leetcode.反转字符串344

import java.util.*


/**
 * https://leetcode-cn.com/problems/reverse-string/
 *
 *  输入：["h","e","l","l","o"]
 *  输出：["o","l","l","e","h"]
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val chars = charArrayOf('h','e','l','l','o')
            SolutionKt().reverseString(chars)
            println(Arrays.toString(chars))
        }
    }

    fun reverseString(s: CharArray): Unit {
        var i = 0; var j = s.size - 1
        while (i <= j) {
            swap(s, i++, j--)
        }
    }

    /**
     * Swaps x[a] with x[b].
     */
    private fun swap(x: CharArray, a: Int, b: Int) {
        val t = x[a]
        x[a] = x[b]
        x[b] = t
    }

}
